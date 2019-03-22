package Tree;

import Excepciones.isEmptyException;
import Nodes.Node;
import Nodes.PrintableNode;

public class avlTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    private int nodeCount = 0, height;

    public avlTree(T value) {
        root = new Node<>(value);
        root.setCount(0);
        root.setLevel(0);
        root.setHeight(0);
        nodeCount++;
    }

    @Override
    public boolean isEmpty() {
        return width() == 0;
    }

    @Override
    public boolean insert(T value) {
        if (value == null) return false;
        root = insert(root, value);
        nodeCount++;
        return true;

    }

    @Override
    public boolean insert(Node<T> node) {
        return insert(node.getValue());
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            Node<T> nod = new Node(value);
            nod.setCount(0);
            update(nod);
            return balance(nod);
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (cmp > 0) {
            node.setRight(insert(node.getRight(), value));
        } else {
            node.setCount(node.getCount() + 1);
        }
        update(node);
        return balance(node);

    }

    @Override
    public boolean remove(T value) {
        if (value == null) return false;
        if (search(root, value) != null) {
            root = remove(root, value);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node<T> remove(Node<T> node, T elem) {
        if (node == null) return null;
        if (elem.equals(node.getValue())) {
            if (node.getCount() > 0) {
                node.setCount(node.getCount() - 1);
                return node;
            }
        }
        int cmp = elem.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(remove(node.getLeft(), elem));
        } else if (cmp > 0) {
            node.setRight(remove(node.getRight(), elem));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                if (node.getLeft().getHeight() > node.getRight().getHeight()) {
                    T successorValue = findMax(node.getLeft());
                    node.setValue(successorValue);
                    node.setLeft(remove(node.getLeft(), successorValue));
                } else {
                    T successorValue = findMin(node.getRight());
                    node.setValue(successorValue);
                    node.setRight(remove(node.getRight(), successorValue));
                }
            }
        }
        update(node);
        return balance(node);

    }

    @Override
    public void breadthFirstTraversal() {
        printByLevel();
    }

    @Override
    public Node<T> search(T value) {
        return search(root, value);
    }

    private Node<T> search(Node<T> node, T value) {
        if (node == null) return null;
        if (value.equals(node.getValue())) return node;
        return value.compareTo(node.getValue()) < 0 ? search(node.getLeft(), value) : search(node.getRight(), value);
    }

    @Override
    public T biggest() {
        return findMax(root);
    }

    @Override
    public T minor() {
        return findMin(root);
    }

    private T findMin(Node<T> node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node.getValue();
    }

    private T findMax(Node<T> node) {
        while (node.getRight() != null)
            node = node.getRight();
        return node.getValue();
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(" " + node.getValue() + "{" + node.getLevel() + "," + node.getCount() + "}");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(" " + node.getValue() + "{" + node.getLevel() + "," + node.getCount() + "}");
        }
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(" " + node.getValue() + "{" + node.getLevel() + "," + node.getCount() + "}");
            inOrder(node.getRight());
        }
    }

    @Override

    public int heightDesc() {
        return root.getHeight();
    }

    @Override
    public int heightAsc() {
        height = 0;
        height(root, 1);
        return height;
    }

    public void printLevel(int level) {
        printLevel(root, level);
    }


    private void printByLevel() {
        int h = heightAsc();
        int i;
        for (i = 1; i <= h; i++) {
            System.out.print("Nivel " + i + " :");
            printLevel(root, i);
            System.out.println();
        }
    }

    private void printLevel(Node<T> root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.getValue() + " ");
        else if (level > 1) {
            printLevel(root.getLeft(), level - 1);
            printLevel(root.getRight(), level - 1);
        }
    }


    private void height(Node<T> reco, int nivel) {
        if (reco != null) {
            reco.setLevel(nivel - 1);
            height(reco.getLeft(), nivel + 1);
            if (nivel > height) {
                height = nivel;
            }
            reco.setLevel(nivel - 1);
            height(reco.getRight(), nivel + 1);
        }
    }

    @Override
    public int between(T start, T end) {
        return getCount(root, start, end);
    }

    private int getCount(Node<T> node, T low, T high) {
        if (node == null) {
            return 0;
        }
        if (node.getValue().compareTo(low) > 0 || node.getValue().equals(low)
                && node.getValue().compareTo(high) < 0 || node.getValue().equals(high)) {
            return 1 + this.getCount(node.getLeft(), low, high)
                    + this.getCount(node.getRight(), low, high);
        } else if (node.getValue().compareTo(low) < 0) {
            return this.getCount(node.getRight(), low, high);
        } else {
            return this.getCount(node.getLeft(), low, high);
        }
    }

    @Override
    public int width() {
        return nodeCount;
    }

    private void update(Node<T> node) {
        int leftNodeHeight = (node.getLeft() == null) ? -1 : node.getLeft().getHeight();
        int rightNodeHeight = (node.getRight() == null) ? -1 : node.getRight().getHeight();
        node.setHeight(1 + Math.max(leftNodeHeight, rightNodeHeight));
        node.setBf(rightNodeHeight - leftNodeHeight);
    }

    private Node<T> balance(Node<T> node) {
        if (node.getBf() == -2) {
            if (node.getLeft().getBf() <= 0) {
                return leftLeftCase(node);
            } else {
                return leftRightCase(node);
            }
        } else if (node.getBf() == +2) {
            if (node.getRight().getBf() >= 0) {
                return rightRightCase(node);
            } else {
                return rightLeftCase(node);
            }
        }
        return node;
    }

    private Node<T> leftLeftCase(Node<T> node) {
        return rightRotation(node);
    }

    private Node<T> leftRightCase(Node<T> node) {
        node.setLeft(leftRotation(node.getLeft()));
        return leftLeftCase(node);
    }

    private Node<T> rightRightCase(Node<T> node) {
        return leftRotation(node);
    }

    private Node<T> rightLeftCase(Node<T> node) {
        node.setRight(rightRotation(node.getRight()));
        return rightRightCase(node);
    }

    private Node<T> leftRotation(Node<T> node) {
        Node<T> newParent = node.getRight();
        node.setRight(newParent.getLeft());
        newParent.setLeft(node);
        update(node);
        update(newParent);
        return newParent;
    }

    private Node<T> rightRotation(Node<T> node) {
        Node newParent = node.getLeft();
        node.setLeft(newParent.getRight());
        newParent.setRight(node);
        update(node);
        update(newParent);
        return newParent;
    }

    @Override
    public String toString() {
        return TreePrinter.getTreeDisplay(root);
    }

    public boolean validateBSTInvarient(Node<T> node) {
        if (node == null) return true;
        T val = node.getValue();
        boolean isValid = true;
        if (node.getLeft() != null) isValid = isValid && node.getLeft().getValue().compareTo(val) < 0;
        if (node.getRight() != null) isValid = isValid && node.getRight().getValue().compareTo(val) > 0;
        return isValid && validateBSTInvarient(node.getLeft()) && validateBSTInvarient(node.getRight());
    }

}
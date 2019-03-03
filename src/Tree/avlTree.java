package Tree;

import Nodes.Node;
import Nodes.PrintableNode;

public class avlTree<T extends Comparable<T>> implements Iterable<T> {


    public avlTree(T value) {
        root = new Node<>(value);
        root.setCount(0);
        root.setLevel(0);
        root.setHeight(0);
    }

    private Node<T> root;

    private int nodeCount = 0;

    public int height() {
        if (root == null) return 0;
        return root.getHeight();
    }

    public int size() {
        return nodeCount;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {

        if (node == null) return false;

        int cmp = value.compareTo(node.getValue());

        if (cmp < 0) return contains(node.getLeft(), value);

        if (cmp > 0) return contains(node.getRight(), value);

        return true;

    }

    public boolean insert(T value) {
        if (value == null) return false;
        root = insert(root, value);
        nodeCount++;
        return true;

    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null){
            Node<T> nod =  new Node(value);
            nod.setCount(0);
            return nod;
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

    public boolean remove(T elem) {
        if (elem == null) return false;
        if (contains(root, elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node<T> remove(Node<T> node, T elem) {
        if (node == null) return null;

        if(elem.equals(node.getValue())){
            if(node.getCount() > 0){
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

    public java.util.Iterator<T> iterator() {

        final int expectedNodeCount = nodeCount;
        final java.util.Stack<PrintableNode> stack = new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {

                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();

                while (trav != null && trav.getLeft() != null) {
                    stack.push(trav.getLeft());
                    trav = trav.getLeft();
                }

                PrintableNode<T> node = stack.pop();

                if (node.getRight() != null) {
                    stack.push(node.getRight());
                    trav = node.getRight();
                }

                return (T) node.getValue();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
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
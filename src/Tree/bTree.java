package Tree;

import Excepciones.isEmptyException;
import Nodes.Node;

public class bTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int nodeCount;
    int height;

    public bTree(Node<T> node) {
        this(node.getValue());
    }

    public bTree(){
        root = new Node<>();
        root.setCount(0);
        root.setHeight(0);
        root.setLevel(0);
    }

    public bTree(T value) {
        root = new Node<>(value);
        root.setCount(0);
        root.setHeight(0);
        root.setLevel(0);
    }

    @Override
    public boolean isEmpty() throws isEmptyException {
        if (root == null) {
            throw new isEmptyException("Tree is empty");
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(T value) {
        if (value == null) return false;
        else if (root.getValue() == null) {
            root.setValue(value);
            return true;
        } else insert(root, value, root.getLevel());
        nodeCount++;
        return true;
    }

    private Node<T> insert(Node<T> node, T value, int level) {
        if (node == null) {
            Node<T> nod = new Node(value);
            nod.setLevel(level);
            nod.setCount(0);
            return nod;
        }
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value, level + 1));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), value, level + 1));
        } else {
            node.setCount(node.getCount() + 1);
        }
        update(node);
        return node;
    }

    private void update(Node<T> node) {
        int leftNodeHeight = (node.getLeft() == null) ? -1 : node.getLeft().getHeight();
        int rightNodeHeight = (node.getRight() == null) ? -1 : node.getRight().getHeight();
        node.setHeight(1 + Math.max(leftNodeHeight, rightNodeHeight));
        node.setBf(rightNodeHeight - leftNodeHeight);
    }

    @Override
    public boolean insert(Node<T> node) {
        return insert(node.getValue());
    }

    @Override
    public boolean remove(T value) {
        boolean isThere = false;
        Node<T> tmp = search(value);
        if (tmp != null) {
            isThere = true;
            remove(tmp, value);
            nodeCount--;
        }
        return isThere;
    }

    private Node<T> remove(Node<T> current, T value) {
        if (current.getCount() > 0) {
            current.setCount(current.getCount() - 1);
            return current;
        } else {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }
            T smallest = minor(current.getRight()).getValue();
            current.setValue(smallest);
            current.setRight(remove(current.getRight(), smallest));
            update(current);
            return current;
        }
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
        return biggest(root);
    }

    private T biggest(Node<T> node) {
        return node.getRight() == null ? node.getValue() : biggest(node.getRight());
    }

    @Override
    public T minor() {
        return minor(root).getValue();
    }

    private Node<T> minor(Node<T> node) {
        return node.getLeft() == null ? node : minor(node.getLeft());
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

    public void printLevel(int level){
        printLevel(root,level);
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

    private void printByLevel()
    {
        int h = heightAsc();
        int i;
        for (i=1; i<=h; i++) {
            System.out.print("Nivel " + i + " :");
            printLevel(root, i);
            System.out.println();
        }
    }

    private void printLevel (Node<T> root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.getValue() + " ");
        else if (level > 1)
        {
            printLevel(root.getLeft(), level-1);
            printLevel(root.getRight(), level-1);
        }
    }

    @Override
    public int width() {
        return this.nodeCount;
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
            return (1 + node.getCount()+ this.getCount(node.getLeft(), low, high)
                    + this.getCount(node.getRight(), low, high));
        } else if (node.getValue().compareTo(low) < 0) {
            return this.getCount(node.getRight(), low, high);
        } else {
            return this.getCount(node.getLeft(), low, high);
        }
    }

    @Override
    public String toString() {
        return TreePrinter.getTreeDisplay(root);
    }

}

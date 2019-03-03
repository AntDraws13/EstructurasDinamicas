package Tree;

import Excepciones.isEmptyException;
import Nodes.Node;

public class bTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public bTree(Node<T> node) {
        this(node.getValue());
    }

    public bTree(T value) {
        root = new Node<>(value);
        root.setCount(0);
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
        return true;
    }

    private Node<T> insert(Node<T> node, T value, long level) {
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
        return node;
    }

    @Override
    public boolean insert(Node<T> node) {
        return insert(node.getValue());
    }

    @Override
    public boolean remove(T value) {
        boolean isThere = false;
        if(search(value) != null) isThere = true;
        remove(root, value);
        return isThere;
    }

    private Node<T> remove(Node current, T value) {
        if (current == null) {
            return null;
        }
        if (value.equals(current.getValue())) {

            if(current.getCount() > 0){
                current.setCount(current.getCount()-1);
                return current;
            }
            else {
                if (current.getLeft() == null && current.getRight() == null) {
                    return null;
                }
                if (current.getRight() == null) {
                    return current.getLeft();
                }
                if (current.getLeft() == null) {
                    return current.getRight();
                }
                T smallest = (T) minor(current);
                current.setValue(smallest);
                current.setRight(remove(current.getRight(), smallest));
                return current;
            }
        }
        if (current.getValue().compareTo(value) > 0) {
            current.setLeft(remove(current.getLeft(), value));
            return current;
        }
        current.setRight(remove(current.getRight(), value));
        return current;
    }

    @Override
    public T depthFirstSearch() {
        return null;
    }

    @Override
    public T search(T value) {
        return search(root, value);
    }

    private T search(Node<T> node, T value) {
        if (node == null) return null;
        if (value.equals(node.getValue())) return node.getValue();
        return value.compareTo(node.getValue()) < 0 ? search(node.getLeft(), value) : search(node.getRight(), value);
    }

    @Override
    public void reFactor(){

    }

    @Override
    public T biggest() {
        return biggest(root);
    }

    private T biggest(Node<T> node){
        return node.getRight() == null ? node.getValue() : biggest(node.getRight());
    }

    @Override
    public T minor() {
        return minor(root);
    }

    private T minor(Node<T> node){
        return node.getLeft() == null ? node.getValue() : minor(node.getLeft());
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
    public int height() {
        return 0;
    }

    @Override
    public int width() {
        return 0;
    }

    @Override
    public void between(T start, T end) {

    }

    @Override
    public String toString() {
        return TreePrinter.getTreeDisplay(root);
    }

}

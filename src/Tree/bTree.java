package Tree;

import Excepciones.isEmptyException;
import Nodes.Node;

public class bTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public bTree(Node<T> node) {
        root = new Node<>(node.getValue());
    }

    public bTree(T value){
        root = new Node<>(value);
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
        return false;
    }

    @Override
    public boolean insert(Node<T> node) {
        return false;
    }

    @Override
    public boolean remove(T value) {
        return false;
    }

    @Override
    public T depthFirstSearch() {
        return null;
    }

    @Override
    public T search(T value) throws isEmptyException {
        return null;
    }

    @Override
    public void reFactor() throws isEmptyException {

    }

    @Override
    public T biggest() {
        return null;
    }

    @Override
    public T minor() {
        return null;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void inOrder() {

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
}

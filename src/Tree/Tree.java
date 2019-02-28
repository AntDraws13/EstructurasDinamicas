package Tree;

import Excepciones.*;
import Nodes.Node;

public interface Tree<T extends Comparable<T>> {

    boolean isEmpty() throws isEmptyException;
    boolean insert(T value);
    boolean insert(Node<T> node);
    boolean remove(T value);

    T depthFirstSearch();
    T search (T value) throws isEmptyException;
    void reFactor() throws isEmptyException;

    T biggest();
    T minor();

    void preOrder();
    void postOrder();
    void inOrder();

    int height();
    int width();
    void between(T start, T end);

}

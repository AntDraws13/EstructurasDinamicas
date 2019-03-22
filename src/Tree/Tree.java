package Tree;

import Excepciones.*;
import Nodes.Node;

public interface Tree<T extends Comparable<T>> {

    boolean isEmpty() throws isEmptyException;
    boolean insert(T value);
    boolean insert(Node<T> node);
    boolean remove(T value);

    void breadthFirstTraversal();
    Node<T> search (T value) throws isEmptyException;

    T biggest();
    T minor();

    void preOrder();
    void postOrder();
    void inOrder();

    int heightDesc();
    int heightAsc();
    int width();
    int between(T start, T end);

}

package List;

import Excepciones.isEmptyException;
import Nodes.Node;

import java.util.Iterator;

public interface Listas<E extends Comparable<E>> extends Iterable<E> {

    boolean Add(E value);

    boolean Add(Node<E> node);

    boolean AddAtStart(E value);

    boolean AddAtStart(Node<E> node);

    boolean AddAt(int position, E value);

    boolean AddAt(Node<E> value, int position);

    boolean AddAfter(E after, E value);

    boolean AddBefore(E before, E value);

    boolean RemoveAll(E value);

    boolean RemoveBefore(Node<E> node);

    boolean RemoveBefore(E value);

    boolean RemoveAfter(E value);

    boolean Remove(E value);

    boolean Remove(Node<E> node);

    boolean RemoveAtStart() throws isEmptyException;

    Node<E> getElementAt(int value);

    boolean isEmpty() throws isEmptyException;

    long getLength();

    Iterator<E> iterator();
}

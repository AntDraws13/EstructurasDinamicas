package Queue;
import Excepciones.*;

public interface Queue<T> {

    boolean enqueue(T value) throws isFullException;
    T       dequeue()        throws isEmptyException;
    boolean removeAll()      throws isEmptyException;
    void    isFull()         throws isFullException;
    void    isEmpty()        throws isEmptyException;
    T       front()          throws isEmptyException;
    T       last()           throws isEmptyException;
}

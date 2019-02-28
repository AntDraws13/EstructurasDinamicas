package Queue;
import Excepciones.*;

public interface Queue<T extends Comparable<T>> extends Iterable<T> {

    boolean enqueue(T value) ;
    T       dequeue()        ;
    boolean removeAll()      ;
    void    isFull()         throws isFullException;
    void    isEmpty()        throws isEmptyException;
    T       front()          ;
    T       last()           ;

}

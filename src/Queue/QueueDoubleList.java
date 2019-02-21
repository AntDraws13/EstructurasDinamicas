package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.DoubleLinkedList;
import List.Listas;

public class QueueDoubleList<T extends Comparable<T>> implements Queue<T> {

    Listas<T> queue;
    private int size;
    private int front = -1;
    private int back = 0;
    private int count;

    public QueueDoubleList(int size){
        queue = new DoubleLinkedList<>(size);
        this.size = size;
    }

    @Override
    public boolean enqueue(T value) throws isFullException {
        return false;
    }

    @Override
    public T dequeue() throws isEmptyException {
        return null;
    }

    @Override
    public boolean removeAll() throws isEmptyException {
        return false;
    }

    @Override
    public void isFull() throws isFullException {

    }

    @Override
    public void isEmpty() throws isEmptyException {

    }

    @Override
    public T front() throws isEmptyException {
        return null;
    }

    @Override
    public T last() throws isEmptyException {
        return null;
    }
}

package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.LinkedLista;

import java.lang.reflect.Array;
import java.util.Iterator;

public class QueueArray<T extends Comparable<T>> implements Queue<T>, Iterable<T> {

    private T[] queue;
    private int size;
    private int front = -1;
    private int back = 0;
    private int count;

    private Class<T> type = null;

    public QueueArray(Class<T> type, int size) {
        this.type = type;
        this.size = size;
        this.queue = (T[]) Array.newInstance(type, size);
    }

    public QueueArray(Class<T> type) {
        this(type, 10);
    }


    @Override
    public boolean enqueue(T value){
        try {
            isFull();
            count++;
            queue[back++ % size] = value;
            return true;
        } catch (isFullException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public T dequeue() {
        try{
            isEmpty();
            count--;
            return queue[++front % size];
        } catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean removeAll(){
        return false;
    }

    @Override
    public void isFull() throws isFullException {
        if (count == size)
            throw new isFullException("Queue is full");
    }

    @Override
    public void isEmpty() throws isEmptyException {
        if (count == 0)
            throw new isEmptyException("Queue is empty");
    }

    @Override
    public T front() {
        return queue[(front+1) % size];
    }

    @Override
    public T last() {
        return queue[(back-1) % size];
    }

    public T[] getQueue() {
        return this.queue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int _front = front;
            int _count = count;
            @Override
            public boolean hasNext() {
                return _count-- != 0;
            }

            @Override
            public T next() {
                return queue[++_front % size];
            }
        };
    }
}

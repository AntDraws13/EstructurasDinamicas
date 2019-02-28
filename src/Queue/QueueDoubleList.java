package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.DoubleLinkedList;
import List.Listas;

import java.util.Iterator;

public class QueueDoubleList<T extends Comparable<T>> implements Queue<T> {

    private Listas<T> queue;
    private int size;
    private int front = -1;
    private int back = 0;
    private int count;

    public QueueDoubleList(int size){
        this.size = size;
        queue = new DoubleLinkedList<>();
        count = 0;
        for (int i = 0; i< size; i++){
            queue.Add((T)null);
        }
    }

    @Override
    public boolean enqueue(T value){
        try{
            isFull();
            count++;
            queue.getElementAt((back++ % size)).setValue(value);
            return true;
        } catch (isFullException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public T dequeue(){
        try {
            isEmpty();
            count--;
            return queue.getElementAt(++front % size).getValue();
        } catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean removeAll() {
        for (int i = 0; i <size; i ++){
            queue.getElementAt(i).setValue((T) null);
        }
        front = -1;
        back = 0;
        count = 0;
        return true;
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
    public T front(){
        try {
            isEmpty();
            return queue.getElementAt((front+1) % size).getValue();
        } catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public T last(){
        try {
            isEmpty();
            return queue.getElementAt((back-1) % size).getValue();
        }catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

}

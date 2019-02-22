package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.DoubleLinkedList;

import java.util.ArrayList;

public class QueueDoubleListPriority<T extends Comparable<T>> {

    ArrayList<DoubleLinkedList<T>> priority;

    enum prioridad {muy_alta, alta, media, baja, muy_baja}

    private int[] size;
    private int[] front;
    private int[] back;
    private int[] count;

    public QueueDoubleListPriority(int size) {

        priority = new ArrayList<>(prioridad.values().length);

        this.size = new int[prioridad.values().length];
        this.front = new int[prioridad.values().length];
        this.back = new int[prioridad.values().length];
        this.count = new int[prioridad.values().length];

        for (int i = 0; i < prioridad.values().length; i++) {
            this.front[i] = -1;
            this.size[i] = size;
            this.back[i] = 0;
            priority.add(new DoubleLinkedList<T>(size));
        }
    }

    public boolean enqueue(int priority, T value) {
        try {
            isFull(priority);
            count[priority]++;
            return this.priority.get(back[priority]++ % size[priority]).AddAtStart(value);
        } catch (isFullException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public T dequeue() throws isEmptyException {
        for (int i = 0; i < prioridad.values().length; i++) {
            if (!isEmpty(i)) {
                count[i]--;
                T value = priority.get(i).getElementAt(++front[i] % size[i]).getValue();
                priority.get(i).Remove(priority.get(i).getElementAt(++front[i] % size[i]));
                return value;
            }
        }
        return null;
    }

    public boolean isFull(int priority) throws isFullException {
        if (count[priority] == size[priority])
            throw new isFullException("Queue is full: "+prioridad.values()[priority]);
        else return false;
    }

    public boolean isEmpty(int priority) throws isEmptyException {
        if (count[priority] == 0)
            throw new isEmptyException("Queue is empty: "+prioridad.values()[priority]);
        else return false;
    }

    public T front() throws isEmptyException {
        for (int i = 0; i < prioridad.values().length; i++) {
            if (!isEmpty(i)) {
                return priority.get(i).getElementAt(((front[i] + 1) % size[i])).getValue();
            }
        }
        return null;
    }

    public T last(){
        for (int i = prioridad.values().length -1; i > 0; i=-1) {
            try {
                if (!isEmpty(i)) {
                    return priority.get(i).getElementAt(((back[i] - 1) % size[i])).getValue();
                }
            } catch (isEmptyException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public static void main(String[] args) throws isEmptyException {
        QueueDoubleListPriority queue = new QueueDoubleListPriority(5);


        queue.enqueue(prioridad.alta.ordinal(), 1);


        for (int i = 0; i < prioridad.values().length; i++) {
            try {
                if (!queue.isEmpty(i)) System.out.println("No vacio: " + prioridad.values()[i]);
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Last in line: "+queue.last());
    }
}

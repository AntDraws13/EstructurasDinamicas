package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import java.util.ArrayList;


public class QueueDoubleListPriority<T extends Comparable<T>> {

    ArrayList<QueueDoubleList<T>> priority;

    public static enum prioridad {muy_alta, alta, media, baja, muy_baja}

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
            this.count[i] = 0;
            priority.add(new QueueDoubleList<T>(size));
        }
    }

    public boolean enqueue(int pos, T value) {
        try{
            isFull(pos);
            count[pos]++;
            priority.get(pos).enqueue(value);
            return true;
        } catch (isFullException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public T dequeue(){
        for (int i = 0; i < size[0]; i++) {
            try{
                isEmpty(i);
                count[i]--;
                return priority.get(i).dequeue();
            } catch (isEmptyException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public boolean removeAll() {
        for (int j = 0; j < prioridad.values().length; j++) {
            for (int i = 0; i < size[0]; i++) {
                priority.get(j).removeAll();
            }
            front[j] = -1;
            back[j] = 0;
            count[j] = 0;
        }
        return true;
    }

    public boolean isFull(int pos) throws isFullException {
        if (count[pos] == size[pos])
            throw new isFullException("Queue is full: " + prioridad.values()[pos]);
        else return false;
    }

    public boolean isEmpty(int pos) throws isEmptyException {
        if (count[pos] == 0)
            throw new isEmptyException("Queue is empty: " + prioridad.values()[pos]);
        else return false;
    }

    public T front() {
        for (int i = 0; i < prioridad.values().length; i++) {
            try {
                if (!isEmpty(i))
                    return priority.get(i).front();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public T last() {
        for (int i = prioridad.values().length - 1; i >= 0; i--) {
            try {
                if (!isEmpty(i))
                    return priority.get(i).last();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}

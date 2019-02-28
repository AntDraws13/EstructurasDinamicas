package Queue;

import java.util.ArrayList;

public class QueueDoubleListPriority<T extends Comparable<T>> {

    ArrayList<QueueDoubleList<T>> priority;

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
            this.count[i] = 0;
            priority.add(new QueueDoubleList<T>(size));
        }
    }



}

package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;

public class PriorityQueue<T extends QueueArray> {

    static QueueArray<Double>[] dobles = new QueueArray[5];

    enum prioridad {muy_alta, alta, media, baja, muy_baja}



    public static void insert(int prioridad, double value) {

        dobles[prioridad].enqueue(value);

    }

    public static void initD() {
        for (int i = 0; i < dobles.length; i++) {
            dobles[i] = new QueueArray<>(Double.class, 4);
        }
    }

    public static void print() {
        for (QueueArray<Double> queue : dobles) {
            try {
                queue.isEmpty();
                for (Double d : queue) {
                    System.out.print(d + ", ");
                }
                System.out.println();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

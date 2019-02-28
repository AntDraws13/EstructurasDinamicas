package app;

import Queue.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author antdr
 */


public class Main {

    public static void main(String[] args) {
        QueueDoubleListPriority<Integer> queue = new QueueDoubleListPriority<Integer>(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int rand = Random(1,99);
                System.out.println("enqueued on " + QueueDoubleListPriority.prioridad.values()[i] + ", " + rand);
                queue.enqueue(i, rand);
            }
        }
        System.out.println("next to dequeue: " + queue.front());

        System.out.println("deque value: " + queue.dequeue());

        System.out.println("next to dequeue: " + queue.front());

        System.out.println("last to dequeue: " + queue.last());

        System.out.println("tried to enqueue value on full queue: ");

        System.out.println("Status:  " + queue.enqueue(3, 2));

        System.out.println("dequeue all values on highest priority until empty exception is thrown, " +
                "then dequeue on next priority ");

        for (int i = 0; i < 5; i++) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }


    public static int Random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

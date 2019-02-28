package app;

import Queue.*;

/**
 * @author antdr
 */


public class Main {
    private static Queue<Integer> queue;
    public static void main(String[] args) {
        queue = new QueueSimpleList<Integer>(5);
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(0);
        queue.enqueue(0);
        queue.enqueue(3);
        System.out.println(queue.dequeue()+ ": Deque element");
        System.out.println(queue.front()+ ": Next to dequeue");
        System.out.println(queue.last()+ ": Last to dequeue");
        System.out.println(queue.dequeue()+ ": Deque element");
        System.out.println(queue.front()+ ": Next to dequeue");
        System.out.println(queue.last()+ ": Last to dequeue");
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(9);  //Esta llamada produce un isFull exception
        System.out.println(queue.last()+ ": Last to dequeue");
        System.out.println(queue.dequeue()+ ": Deque element");
        System.out.println(queue.dequeue()+ ": Deque element");
        System.out.println(queue.dequeue()+ ": Deque element");
        System.out.println(queue.dequeue()+ ": Deque element");
        System.out.println(queue.dequeue()+ ": Deque element");
        System.out.println(queue.dequeue()+ ": Deque element"); //Esta llamada produce un isEmptyException


        System.out.println("Se remueven todos los valores del queue: ");
        queue.removeAll();
        for (Integer i:queue){
            System.out.println(i);
        }
    }
}

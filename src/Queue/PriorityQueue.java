package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;

public class PriorityQueue<T extends QueueArray>{

    static QueueArray<Double>[] dobles = new QueueArray[5];

    enum prioridad {alta, regular, media, baja, muy_baja};

    public static void insert(int prioridad, double value){
        try{
            dobles[prioridad].enqueue(value);
        } catch (isFullException e){
            System.out.println(e.getMessage());
        }
    }

    public static void initD(){
        for (int i = 0; i < dobles.length; i++){
            dobles[i] = new QueueArray<>(Double.class, 4);
        }
    }

    public static void print(){
        for (QueueArray<Double> queue : dobles){
            try{
                queue.isEmpty();
                for (Double d : queue){
                    System.out.print(d+", ");
                }
                System.out.println();
            } catch (isEmptyException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        initD();
        insert(prioridad.alta.ordinal(), 1d);
        insert(prioridad.alta.ordinal(), 2d);
        insert(prioridad.alta.ordinal(), 3d);
        insert(prioridad.regular.ordinal(), 4d);
        insert(prioridad.media.ordinal(), 5d);
        insert(prioridad.baja.ordinal(), 6d);
        insert(prioridad.muy_baja.ordinal(), 7d);
        insert(prioridad.alta.ordinal(), 4d);
        print();
    }
}

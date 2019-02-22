package app;

import Excepciones.isEmptyException;
import Stack.StackDoubleList;
import Stack.Stacks;

/**
 * @author antdr
 */


public class Main {
    public static Stacks<Integer> pila, pila2;
    public static void main(String[] args) throws isEmptyException {
        pila = new StackDoubleList<>(5);
        pila2 = new StackDoubleList<>(5);

        for (int i=0; i<5; i++){
            pila.push(i+1);
            pila2.push(i+1);
        }

        pila.push(5);
        pila2.push(5);

        if(pila.compareTo(pila2) == 0) System.out.println("Equal Stacks");

        System.out.println("Poped Value from pila(1): "+ pila.pop());

        System.out.println("Peaked value on pila(2): "+pila2.peak());

        if(!(pila.compare(pila, pila2) == 0)) System.out.println("Stacks aren't equal.");

    }
}

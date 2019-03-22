package app;

import List.*;
import Stack.*;
import Queue.*;
import Tree.*;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author antdr
 */


public class Main {

    public static void main(String[] args) {
        Tree<Integer> bTree = new bTree<Integer>(); //nuevo arbol con root  = 5
        for (int i = 0; i<15; i++){
            bTree.insert(Random(0,15)); //llenar el arbol random con 15 valores
        }
        System.out.println(bTree.toString()); //Imprimir estructura del arbol
        bTree.breadthFirstTraversal(); //Impresión por nivel
        System.out.println("Cantidad de nodos entre 8 y 20: "+bTree.between(8,20)); //La suma incluye nodos que tengan repetidos
    }

    public static int Random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

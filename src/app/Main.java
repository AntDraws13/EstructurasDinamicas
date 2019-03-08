package app;

import List.*;
import Stack.*;
import Queue.*;
import Tree.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author antdr
 */


public class Main {

    public static void main(String[] args) {
        Listas<Integer> simpleList = new LinkedLista<>();
        Listas<Integer> doubleList = new DoubleLinkedList<>();
        Stacks<Integer> simpleStack = new StackSimpleList<>();
        Stacks<Integer> doubleStack = new StackDoubleList<>();
        Queue<Integer> simpleQueue = new QueueSimpleList<Integer>(10);
        Queue<Integer> doubleQueue = new QueueDoubleList<Integer>(10);
        Tree<Integer> binaryTree = new bTree<Integer>(5);
        Tree<Integer> avlTree = new avlTree<Integer>(5);
    }
    public static int Random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

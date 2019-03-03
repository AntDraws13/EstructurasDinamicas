package app;

import Queue.*;
import Tree.avlTree;
import Tree.bTree;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author antdr
 */


public class Main {

    public static void main(String[] args) {
        avlTree<Integer> avlTree = new avlTree<>(8);

        for (int i = 0; i < 50; i ++){
            avlTree.insert(Random(1,800));
        }

        System.out.println(avlTree.toString());
    }


    public static int Random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

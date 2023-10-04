package problem6;

import problem4.IteratorPREOrder;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        AVLTree<Integer> avlTree = new AVLTree<>();

        avlTree.add(3);
        avlTree.add(5);
        avlTree.add(7);
        avlTree.add(4);
        avlTree.add(1);

        Iterator<Integer> it = new IteratorPREOrder<>(avlTree);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

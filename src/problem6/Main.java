package problem6;

import problem4.BinarySearchTree;
import problem4.IteratorINOrder;

import javax.swing.text.Style;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        AVLTree<Integer> avlTree = new AVLTree<>();

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        Random random = new Random();

        helpers.Timer timer = new helpers.Timer();

        avlTree.add(3);
        avlTree.add(5);
        avlTree.add(7);
        avlTree.add(4);
        avlTree.add(1);

        Iterator<Integer> it = new IteratorINOrder<>(avlTree);

        while (it.hasNext()){
            System.out.println(it.next());
        }

        List<Long> bst_insert_times = new ArrayList<>();
        List<Long> avl_insert_times = new ArrayList<>();



        for (int i = 0; i < 100000; i++) {
            int insert = random.nextInt(1, 5000000);
            bst_insert_times.add(timer.timeItNanoTime(() -> binarySearchTree.add(insert)));
            avl_insert_times.add(timer.timeItNanoTime(() -> avlTree.add(insert)));
        }







    }
}

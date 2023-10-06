package problem6;

import helpers.CSVExporter;
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

        CSVExporter csvExporter = new CSVExporter();

        avlTree.add(3);
        avlTree.add(5);
        avlTree.add(7);
        avlTree.add(4);
        avlTree.add(1);

        Iterator<Integer> it = new IteratorINOrder<>(avlTree);

        while (it.hasNext()){
            System.out.println(it.next());
        }

        List<List<Long>> bst_insert_times_all = new ArrayList<>();
        List<List<Long>> avl_insert_times_all = new ArrayList<>();


        for (int j = 0; j < 20; j++) {
            List<Long> bst_insert_times = new ArrayList<>();
            List<Long> avl_insert_times = new ArrayList<>();
            for (int i = 0; i < 1000000; i++) {
                int insert = random.nextInt(1, 5000000);
                binarySearchTree.add(insert);
                avlTree.add(insert);
                if (i % 10000 == 0) {
                    bst_insert_times.add(timer.timeItNanoTime(() -> binarySearchTree.add(insert)));
                    avl_insert_times.add(timer.timeItNanoTime(() -> avlTree.add(insert)));
                } else {
                    binarySearchTree.add(insert);
                    avlTree.add(insert);
                }
            }
            bst_insert_times_all.add(bst_insert_times);
            avl_insert_times_all.add(avl_insert_times);
        }


        List<Long> bst_insert_times_avg = timer.findAverageRunningTime(bst_insert_times_all);
        List<Long> avl_insert_times_avg = timer.findAverageRunningTime(avl_insert_times_all);

        csvExporter.exportLongTimesToCSV(bst_insert_times_avg, "bst_insert_times_avg");
        csvExporter.exportLongTimesToCSV(avl_insert_times_avg, "avl_insert_times_avg");


        System.out.println(binarySearchTree.getTheHeight());









    }
}

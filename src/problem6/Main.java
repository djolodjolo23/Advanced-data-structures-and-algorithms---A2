package problem6;

import helpers.CSVExporter;
import problem4.BinarySearchTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        AVLTree<Integer> avlTree = new AVLTree<>();

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        Random random = new Random();

        helpers.Timer timer = new helpers.Timer();

        CSVExporter<Long> csvExporterLong = new CSVExporter<>();
        CSVExporter<Integer> csvExporterInteger = new CSVExporter<>();





        List<List<Long>> bst_insert_times_all = new ArrayList<>();
        List<List<Long>> avl_insert_times_all = new ArrayList<>();
        List<List<Integer>> bst_height_all = new ArrayList<>();
        List<List<Integer>> avl_height_all = new ArrayList<>();
        List<List<Long>> bst_remove_all = new ArrayList<>();
        List<List<Long>> avl_remove_all = new ArrayList<>();
        List<List<Long>> bst_find_all = new ArrayList<>();
        List<List<Long>> avl_find_all = new ArrayList<>();


        for (int j = 0; j < 20; j++) {
            List<Long> bst_insert_times = new ArrayList<>();
            List<Long> avl_insert_times = new ArrayList<>();
            List<Integer> bst_height = new ArrayList<>();
            List<Integer> avl_height = new ArrayList<>();
            List<Long> bst_remove = new ArrayList<>();
            List<Long> avl_remove = new ArrayList<>();
            List<Long> bst_find = new ArrayList<>();
            List<Long> avl_find = new ArrayList<>();

            for (int i = 1; i <= 500000; i++) {
                int insert = random.nextInt(1, 10000000);
                //int theI = i;
                binarySearchTree.add(insert);


                avlTree.addTest(insert);
                if (i % 1000 == 0) {
                    bst_insert_times.add(timer.timeItNanoTime(() -> binarySearchTree.add(insert)));
                    avl_insert_times.add(timer.timeItNanoTime(() -> avlTree.add(insert)));
                    bst_height.add(binarySearchTree.getRoot().height);
                    avl_height.add(avlTree.getRoot().height);
                    bst_find.add(timer.timeItNanoTime(() -> binarySearchTree.findNode(insert)));
                    avl_find.add(timer.timeItNanoTime(() -> avlTree.findNode(insert)));
                    BinarySearchTree.BinaryNode<Integer> node = binarySearchTree.findNodeWithIndex(random.nextInt(binarySearchTree.size())); // using iterator to find it to avoid the overhead on the timer
                    bst_remove.add(timer.timeItNanoTime(() -> binarySearchTree.remove(node.element)));
                    avl_remove.add(timer.timeItNanoTime(() -> avlTree.remove(node.element)));
                } else {
                    binarySearchTree.add(insert);
                    avlTree.addTest(insert);
                }
            }
            bst_insert_times_all.add(bst_insert_times);
            avl_insert_times_all.add(avl_insert_times);
            bst_height_all.add(bst_height);
            avl_height_all.add(avl_height);
            bst_remove_all.add(bst_remove);
            avl_remove_all.add(avl_remove);
            bst_find_all.add(bst_find);
            avl_find_all.add(avl_find);
            binarySearchTree.resetTree(binarySearchTree);
            avlTree.resetTree(avlTree);
        }


        List<Long> bst_insert_times_avg = timer.findAverageRunningTimeLong(bst_insert_times_all);
        List<Long> avl_insert_times_avg = timer.findAverageRunningTimeLong(avl_insert_times_all);
        List<Integer> bst_height_avg = timer.findAverageIntegers(bst_height_all);
        List<Integer> avl_height_avg = timer.findAverageIntegers(avl_height_all);
        List<Long> bst_remove_avg = timer.findAverageRunningTimeLong(bst_remove_all);
        List<Long> avl_remove_avg = timer.findAverageRunningTimeLong(avl_remove_all);
        List<Long> bst_find_avg = timer.findAverageRunningTimeLong(bst_find_all);
        List<Long> avl_find_avg = timer.findAverageRunningTimeLong(avl_find_all);


        csvExporterLong.exportTimesToCSV(bst_insert_times_avg, "bst_insert_times_avg.csv");
        csvExporterLong.exportTimesToCSV(avl_insert_times_avg, "avl_insert_times_avg.csv");
        csvExporterInteger.exportTimesToCSV(bst_height_avg, "bst_height_avg.csv");
        csvExporterInteger.exportTimesToCSV(avl_height_avg, "avl_height_avg.csv");
        csvExporterLong.exportTimesToCSV(bst_remove_avg, "bst_remove_avg.csv");
        csvExporterLong.exportTimesToCSV(avl_remove_avg, "avl_remove_avg.csv");
        csvExporterLong.exportTimesToCSV(bst_find_avg, "bst_find_avg.csv");
        csvExporterLong.exportTimesToCSV(avl_find_avg, "avl_find_avg.csv");


        System.out.println("Average bst insert time: " + timer.findAverageLong(bst_insert_times_avg));
        System.out.println("Average bst height: " + timer.findAverageInt(bst_height_avg));
        System.out.println("Average bst remove time: " + timer.findAverageLong(bst_remove_avg));
        System.out.println("Average bst find time: " + timer.findAverageLong(bst_find_avg));
        System.out.println();
        System.out.println("Average avl insert time: " + timer.findAverageLong(avl_insert_times_avg));
        System.out.println("Average avl height: " + timer.findAverageInt(avl_height_avg));
        System.out.println("Average avl remove time: " + timer.findAverageLong(avl_remove_avg));
        System.out.println("Average avl find time: " + timer.findAverageLong(avl_find_avg));









    }
}

package problem5;

import helpers.CSVExporter;
import helpers.PrintStuff;
import helpers.Timer;
import problem4.IteratorPREOrder;
import problem6.AVLTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> bt_original = new BinaryTree<>();
        BinaryTree<Integer> bt_nodes_switched = new BinaryTree<>();
        Timer timer = new Timer();
        CSVExporter<Long> csvExporterLong = new CSVExporter<>();

        int[] nums = {20, 10, 30, 25, 35, 8, 15, 4, 9};
        /*
        for (int num : nums) {
            bt_original.add(num);
            bt_nodes_switched.add(num);
        }
         */

        List<Long> isomorphic_times = new ArrayList<>();


        IsomorphicTester<Integer> isomorphicTester = new IsomorphicTester<>();
        PrintStuff<Integer> printStuff = new PrintStuff<>();
        Iterator<Integer> bt_original_it = new IteratorPREOrder<>(bt_original);
        Iterator<Integer> bt_nodes_switched_it = new IteratorPREOrder<>(bt_nodes_switched);


        int size = 100;
        while (size != 3000) {
            for (int i = 1; i <= size; i++) {
                bt_original.add(i);
                bt_nodes_switched.add(i);
            }
            size += 100;
            isomorphic_times.add(timer.timeItNanoTime(() -> isomorphicTester.testIfTreesAreIsomorphic(bt_original, bt_nodes_switched)));
            bt_original.resetTree(bt_original);
            bt_nodes_switched.resetTree(bt_nodes_switched);
        }

        csvExporterLong.exportTimesToCSV(isomorphic_times, "isomorphic_times.csv");

        /*

        bt_nodes_switched.swapAllPairsOfChildren();



        printStuff.printIteratorValues(bt_original_it);
        printStuff.printIteratorValues(bt_nodes_switched_it);
        printStuff.printIsomorphic(isomorphicTester.testIfTreesAreIsomorphic(bt_original, bt_nodes_switched));

        bt_original_it = new IteratorPREOrder<>(bt_original);
        bt_nodes_switched_it = new IteratorPREOrder<>(bt_nodes_switched);
        bt_nodes_switched.swapChildrenOfASpecificNode(30);

        printStuff.printIteratorValues(bt_original_it);
        printStuff.printIteratorValues(bt_nodes_switched_it);
        printStuff.printIsomorphic(isomorphicTester.testIfTreesAreIsomorphic(bt_original, bt_nodes_switched));

        bt_original_it = new IteratorPREOrder<>(bt_original);
        bt_nodes_switched_it = new IteratorPREOrder<>(bt_nodes_switched);
        bt_nodes_switched.add(5);

        printStuff.printIteratorValues(bt_original_it);
        printStuff.printIteratorValues(bt_nodes_switched_it);
        printStuff.printIsomorphic(isomorphicTester.testIfTreesAreIsomorphic(bt_original, bt_nodes_switched));

         */
    }
}

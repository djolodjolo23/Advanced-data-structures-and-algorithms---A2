package problem5;

import helpers.PrintStuff;
import problem4.IteratorPREOrder;
import problem6.AVLTree;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> bt_original = new BinaryTree<>();
        BinaryTree<Integer> bt_nodes_switched = new BinaryTree<>();

        int[] nums = {20, 10, 30, 25, 35, 8, 15, 4, 9};

        for (int num : nums) {
            bt_original.add(num);
            bt_nodes_switched.add(num);
        }


        IsomorphicTester<Integer> isomorphicTester = new IsomorphicTester<>();
        PrintStuff<Integer> printStuff = new PrintStuff<>();
        Iterator<Integer> bt_original_it = new IteratorPREOrder<>(bt_original);
        Iterator<Integer> bt_nodes_switched_it = new IteratorPREOrder<>(bt_nodes_switched);

        /*
        System.out.println(isomorphicTester.testIfTreesAreIsomorphic(bt_original, bt_nodes_switched));
        for (int i = 0; i < 3000; i++) {
            bt_original.add(i);
            bt_nodes_switched.add(i);
        }
         */

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

    }
}

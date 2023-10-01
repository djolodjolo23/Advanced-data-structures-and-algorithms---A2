package problem5;

import problem4.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> bt_original = new BinaryTree<>();
        BinaryTree<Integer> bt_nodes_switched = new BinaryTree<>();
        bt_original.add(8);
        bt_original.add(4);
        bt_original.add(10);
        bt_original.add(3);
        bt_original.add(5);
        bt_original.add(9);
        bt_nodes_switched.add(8);
        bt_nodes_switched.add(4);
        bt_nodes_switched.add(10);
        bt_nodes_switched.add(3);
        bt_nodes_switched.add(5);
        bt_nodes_switched.add(9);
        //bt_nodes_switched.switchNodes();

        Helper<Integer> helper = new Helper<>();
        System.out.println(helper.checkIfTreesAreIsomorphic(bt_original, bt_nodes_switched));
        for (Integer i : bt_original) {
            System.out.println(i);
        }
        System.out.println();
        for (Integer i : bt_nodes_switched) {
            System.out.println(i);
        }

    }
}

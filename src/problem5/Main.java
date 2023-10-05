package problem5;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> bt_original = new BinaryTree<>();
        BinaryTree<Integer> bt_nodes_switched = new BinaryTree<>();

        IsomorphicTester<Integer> isomorphicTester = new IsomorphicTester<>();



        for (int i = 0; i < 3000; i++) {
            bt_original.add(i);
            bt_nodes_switched.add(i);
        }

        //bt_nodes_switched.swapAllPairsOfChildren();

        System.out.println(isomorphicTester.testIfTreesAreIsomorphic(bt_original, bt_nodes_switched));
        bt_nodes_switched.swapChildToLeftOrRight(6);

        bt_original.swapChildToLeftOrRight(6);
        System.out.println(isomorphicTester.testIfTreesAreIsomorphic(bt_original, bt_nodes_switched));

        for (Integer i : bt_original) { //currently set to INOrder withing BST class
            System.out.println(i);
        }

        for (Integer i : bt_nodes_switched) { //currently set to INOrder withing BST class
            System.out.println(i);
        }

        //Iterator<Integer> itPost = new IteratorPOSTOrder<>()

    }
}

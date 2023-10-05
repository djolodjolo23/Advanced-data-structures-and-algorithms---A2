package problem4;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        var bst = new BinarySearchTree<Integer>();
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(4);
        bst.add(1);

        for (Integer integer : bst) {
            System.out.println(integer);
        }


        int height = bst.getTheHeight(3);
        System.out.println("Height: " + height);

        bst.removeKthLargestElement(5);
        System.out.println(bst.contains(2));
        System.out.println(bst.size());
    }
}

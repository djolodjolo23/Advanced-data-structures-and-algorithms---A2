package problem4;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        var bst = new BinarySearchTree<Integer>();
        bst.add(1);
        bst.add(2);
        bst.add(3);
        bst.add(4);
        bst.add(5);
        bst.add(6);
        bst.add(7);

        bst.remove(1);
        bst.remove(2);
        bst.remove(4);
        System.out.println(bst.contains(2));
        System.out.println(bst.size());
        System.out.println(bst.height());
    }
}

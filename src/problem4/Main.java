package problem4;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        var bst = new BinarySearchTree<Integer>();
        bst.add(8);
        bst.add(4);
        bst.add(10);
        bst.add(3);
        bst.add(5);
        bst.add(9);
        bst.add(11);

        int height = bst.getTheHeight(8);
        System.out.println("Height: " + height);

        Iterator<Integer> it = bst.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(bst.contains(2));
        System.out.println(bst.size());
    }
}

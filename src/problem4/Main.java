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


        bst.remove(4);
        bst.remove(10);
        bst.remove(3);
        bst.remove(5);
        bst.remove(9);
        bst.remove(11);
        height = bst.getTheHeight(7);
        System.out.println("Height: " + height);
        System.out.println(bst.contains(2));
        System.out.println(bst.size());
    }
}

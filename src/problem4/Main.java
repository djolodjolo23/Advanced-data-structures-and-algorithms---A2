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


        Iterator<Integer> it = bst.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }


        bst.remove(1);
        bst.remove(2);
        bst.remove(4);
        System.out.println(bst.contains(2));
        System.out.println(bst.size());
        System.out.println(bst.height());
    }
}

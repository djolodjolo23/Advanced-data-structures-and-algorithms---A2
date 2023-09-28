package problem4;

public class Main {

    public static void main(String[] args) {


        var bst = new BinarySearchTree<Integer>();
        bst.add(1);
        bst.add(5);
        bst.add(6);
        bst.add(2);
        bst.remove(6);
        System.out.println(bst.contains(6));
    }
}

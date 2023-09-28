package problem4;

public class Main {

    public static void main(String[] args) {


        var bst = new BinarySearchTree<Integer>();
        bst.insert(1);
        bst.insert(5);
        bst.insert(6);
        bst.insert(2);

        System.out.println(bst.contains(6));
    }
}

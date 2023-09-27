package problem3;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {



        String path = "C:/Users/dimit/tree_testing";

        Tree tree = new Tree(path);

        Iterator<TreeNode> it = tree.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
        tree.addChild();

        System.out.println("");
    }
}

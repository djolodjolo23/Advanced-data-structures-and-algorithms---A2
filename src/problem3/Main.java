package problem3;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        String path = ""; //TODO: Provide the path of a folder. Absolute paths are used.
        //String path = scanner.nextLine();

        Tree tree = new Tree(path);

        Iterator<TreeNode> it = tree.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
        //tree.addChild(scanner); //TODO: After the elements are listed in a tree, you can add an element with input
        //TreeNode tn = tree.findTreeNode("") // TODO: Type in the name of a node to find it.

        System.out.println("");
    }
}

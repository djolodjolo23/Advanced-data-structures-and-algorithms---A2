package problem3;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        //String path = "C:/Users/dimit/tree_testing";
        System.out.println("Provide the path of the root folder: ");
        String path = scanner.nextLine();

        Tree tree = new Tree(path);

        Iterator<TreeNode> it = tree.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
        //tree.addChild(scanner);

        System.out.println("");
    }
}

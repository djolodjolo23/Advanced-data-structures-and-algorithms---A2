package problem3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        Tree tree = new Tree(path);

        tree.walkThroughTree();


        TreeNode tn = tree.getNodeByName("2");
        System.out.println(tn.toString());


    }
}

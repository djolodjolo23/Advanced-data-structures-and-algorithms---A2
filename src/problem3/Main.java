package problem3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Provide the directory to list the files and form a tree: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        Tree tree = new Tree(path);

        tree.walkThroughTree();

        //tree.addChild(); TODO: adding a child will list all the directories where
        //                      a child can be added and it will require input for a child name.


        //TreeNode tn = tree.getNodeByName(" "); TODO: here you can provide a name of the node to get all the details
        //System.out.println(tn.toString());


    }
}

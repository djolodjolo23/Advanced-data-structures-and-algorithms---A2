package problem3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {



        String path = "C:/Users/dimit/tree_testing";
        Tree tree = new Tree(path);
        List<TreeNode> nodes = tree.getNodes();
        for (TreeNode n : nodes) {
            System.out.println(n.getName());
        }
    }
}

package problem3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        String path = "C:/Users/dimit/tree_testing";

        Tree tree = new Tree(path);

        tree.walkThroughTree();
        tree.addChild();
        tree.walkThroughTree();

    }
}

package problem3;

import problem1.Deque;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Tree {

    private String rootPath;
    public Tree(String rootPath) {
        this.rootPath = rootPath;
    }

    public void build(String inputPath) throws Exception {
        Path rootPath = Paths.get(inputPath);
        boolean exists = Files.exists(rootPath);
        if (exists) {

        } else {
            throw new Exception("Path does not exist!");
        }
    }

}

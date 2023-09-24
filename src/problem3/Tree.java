package problem3;

import problem1.Deque;

import java.io.File;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Tree {

    private String rootPath;

    private List<TreeNode> nodes;
    public Tree(String rootPath) {
        nodes = new ArrayList<>();
        this.rootPath = rootPath;
        this.build2(rootPath);
    }

    public void build(String inputPath) {
        Path rootPath = Paths.get(inputPath);
        File parentDir = new File(String.valueOf(rootPath));

        TreeNode rootNode = new TreeNode(parentDir.getName());
        File[] elements = parentDir.listFiles();
        nodes.add(rootNode);
        if (elements.length != 0) {
            rootNode.setFirstChild(elements[0].getName());
        }
        assert elements != null;
        for (int i = 0; i < elements.length; i++) {
            File first = elements[i];
            if (first.isFile() && i != elements.length - 1) {
                TreeNode treeNode1 = new TreeNode(first.getName());
                nodes.add(treeNode1);
                File second = elements[i + 1];
                TreeNode treeNode2 = new TreeNode(second.getName());
                treeNode1.setRightSibling(second.getName());
                nodes.add(treeNode2);
            }
            if (first.isDirectory()) {

                build(first.getPath());
            }
        }
    }

    public void build2(String inputPath) {
        File parentDir = new File(String.valueOf(inputPath));
        File[] elements = parentDir.listFiles();
        if (nodes.isEmpty()) {
            TreeNode rootNode = new TreeNode(parentDir.getName());
            nodes.add(rootNode);
        }
        if (elements == null) {
            System.err.println("Failed to list files in "+ parentDir.getName());
            return;
        }
        TreeNode currentNode = nodes.get(nodes.size()-1);
        if (elements.length != 0) {
            currentNode.setFirstChild(elements[0].getName());
        }
        for (int i = 0; i < elements.length; i++) {
            File first = elements[i];
            TreeNode treeNode1 = new TreeNode(first.getName());
            nodes.add(treeNode1);
            if (i != elements.length - 1) {
                File second = elements[i + 1];
                treeNode1.setRightSibling(second.getName());
            }

            if (first.isDirectory()) {
                build2(first.getPath());
            }
        }
    }
}

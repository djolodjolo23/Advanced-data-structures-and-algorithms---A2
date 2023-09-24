package problem3;

import problem1.Deque;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tree {


    private List<TreeNode> nodes;
    public Tree(String rootPath) {
        nodes = new ArrayList<>();
        this.buildTree(rootPath);
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void buildTree(String inputPath) {
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
                buildTree(first.getPath());
            }
        }
    }
}

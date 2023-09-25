package problem3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Tree {

    private List<TreeNode> nodes;

    public Tree(String rootPath) {
        nodes = new ArrayList<>();
        this.buildTree(rootPath);
    }

    public void buildTree(String inputPath) {
        File parentDir = new File(String.valueOf(inputPath));
        File[] elements = parentDir.listFiles();
        if (nodes.isEmpty()) {
            TreeNode rootNode = new TreeNode(parentDir.getName(), parentDir.getAbsolutePath());
            directoryCheck(parentDir, rootNode);
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
            TreeNode treeNode1 = new TreeNode(first.getName(), first.getAbsolutePath());
            directoryCheck(first, treeNode1);
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

    public void directoryCheck(File file, TreeNode treeNode) {
        treeNode.setDirectory(file.isDirectory());
    }

    public void walkThroughTree() {
        for (TreeNode tn : nodes) {
            System.out.println(tn.getName());
        }
    }

    private void updateTree(TreeNode pointerNode, TreeNode nextNode) {
        int pointerIndex = nodes.indexOf(pointerNode);
        nodes.add(pointerIndex + 1, nextNode);
    }

    public TreeNode getNodeByName(String name) {
        TreeNode treeNode = null;
        for (TreeNode tn : nodes) {
            if (Objects.equals(tn.getName(), name)) {
                treeNode = tn;
            }
        }
        return treeNode;
    }

    public void walkThroughFolders() {
        for (TreeNode tn : nodes) {
            if (tn.isDirectory()) {
                System.out.println(tn.getName());
            }
        }
    }

    public String getAbsolutePathOfANode(String nodeName) {
        String wantedNode = null;
        for (TreeNode node : nodes) {
            if (node.getAbsolutePath().endsWith(nodeName)) {
                wantedNode = node.getAbsolutePath();
            }
        }
        return wantedNode;
    }


    public void addChild() {
        Scanner scanner = new Scanner(System.in);
        walkThroughFolders();
        System.out.println("Provide the file to add a child, choose one from the top list: ");
        String folderName = scanner.nextLine();
        File parentDir = new File(getAbsolutePathOfANode(folderName));
        if (!parentDir.exists() || !parentDir.isDirectory()) {
            System.out.println("The specified folder does not exist.");
        }
        File[] elements = parentDir.listFiles();
        System.out.println("Provide the file name: ");
        String fileName = scanner.nextLine();
        File newFile = new File(parentDir, fileName);
        try {
            if (newFile.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("Failed to create file.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TreeNode newNode = new TreeNode(fileName, newFile.getAbsolutePath());
        assert elements != null;
        if (elements.length == 0) {
            TreeNode parentNode = getNodeByName(folderName);
            parentNode.setFirstChild(newNode.getName());
            updateTree(parentNode, newNode);
        } else {
            TreeNode childNode = getNodeByName(elements[elements.length - 1].getName());
            childNode.setRightSibling(newNode.getName());
            updateTree(childNode, newNode);
        }
    }
}

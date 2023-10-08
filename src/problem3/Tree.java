package problem3;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Tree implements Iterable<TreeNode> {

    private TreeNode lastNode;

    private TreeNode rootNode;

    private int theSize;

    private Iterator<TreeNode> myIterator;


    public Tree(String rootPath) {
        theSize = 0;
        this.buildTree(rootPath);
        myIterator = iterator();
    }

    /**
     * The iterator for the Binary search tree.
     * @return can be Post, Pre.
     * TODO: Change the return object to iterator of your choice for testing.
     */
    @Override
    public Iterator<TreeNode> iterator() {
        return new IteratorPOSTOrder(rootNode);
    }


    public void buildTree(String inputPath) {
        File parentDir = new File(String.valueOf(inputPath));
        File[] elements = parentDir.listFiles();
        if (theSize == 0) {
            TreeNode rootNode = new TreeNode(parentDir.getName(), parentDir.getAbsolutePath());
            lastNode = rootNode;
            this.rootNode = rootNode;
            directoryCheck(parentDir, rootNode);
            theSize += 1;
        }
        if (elements == null) {
            System.err.println("Failed to list files in "+ parentDir.getName());
            return;
        }
        TreeNode firstNode = null;
        if (elements.length != 0) {
            firstNode = new TreeNode(elements[0].getName(), elements[0].getAbsolutePath());
            lastNode.setFirstChild(firstNode);
        }
        for (int i = 0; i < elements.length; i++) {
            File firstFile = elements[i];
            lastNode = firstNode;
            directoryCheck(firstFile, firstNode);
            if (firstFile.isDirectory()) {
                buildTree(firstFile.getPath());
            }
            if (i != elements.length - 1) {
                File secondFile = elements[i + 1];
                TreeNode secondNode = new TreeNode(secondFile.getName(), secondFile.getAbsolutePath());
                firstNode.setRightSibling(secondNode);
                firstNode = secondNode;
            }
        }
    }

    public void directoryCheck(File file, TreeNode treeNode) {
        treeNode.setDirectory(file.isDirectory());
    }


    public String getAbsolutePathOfANode(String nodeName) {
        String absPath = null;
        while (myIterator.hasNext()) {
            TreeNode treeNode = myIterator.next();
            if (treeNode.getName().equals(nodeName)) {
               absPath = treeNode.getAbsolutePath();
               break;
            }
        }
        return absPath;
    }


    public void addChild(Scanner scanner) {
        System.out.println("Provide the file to add a child, choose one from the top list. Choose the file without the extension: ");
        String folderName = scanner.nextLine();
        File parentDir = new File(getAbsolutePathOfANode(folderName));
        if (!parentDir.exists() || !parentDir.isDirectory()) {
            throw new NoSuchElementException("The specified file is not a folder.");
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
            TreeNode parentNode = findTreeNode(folderName);
            parentNode.setFirstChild(newNode);
        } else {
            TreeNode childNode = findTreeNode(elements[elements.length - 1].getName());
            childNode.setRightSibling(newNode);
        }
    }

    public TreeNode findTreeNode(String name) {
        TreeNode treeNode = null;
        while (myIterator.hasNext()) {
            treeNode = myIterator.next();
            if (Objects.equals(treeNode.getName(), name)) {
                break;
            }
        }
        return treeNode;
    }



}

package problem3;

public class TreeNode {

    private String name;
    private String firstChild;
    private String rightSibling;
    private boolean directory;

    private String absolutePath;

    public TreeNode(String name, String absolutePath){
        this.name = name;
        this.firstChild = null;
        this.rightSibling = null;
        this.absolutePath = absolutePath;
    }


    public void setFirstChild(String firstChild) {
        this.firstChild = firstChild;
    }


    public String getName() {
        return name;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public boolean isDirectory() {
        return directory;
    }

    public String getFirstChild() {
        return firstChild;
    }

    public String getRightSibling() {
        return rightSibling;
    }

    public void setRightSibling(String rightSibling) {
        this.rightSibling = rightSibling;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", firstChild='" + firstChild + '\'' +
                ", rightSibling='" + rightSibling + '\'' +
                ", absolutePath='" + absolutePath + '\'' +
                '}';
    }
}

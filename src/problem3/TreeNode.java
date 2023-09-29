package problem3;

public class TreeNode {

    public String name;
    public TreeNode firstChild;
    public TreeNode rightSibling;
    public boolean directory;

    public String absolutePath;

    public TreeNode(String name, String absolutePath){
        this.name = name;
        this.absolutePath = absolutePath;
    }


    public void setFirstChild(TreeNode firstChild) {
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

    public void setRightSibling(TreeNode rightSibling) {
        this.rightSibling = rightSibling;
    }

}

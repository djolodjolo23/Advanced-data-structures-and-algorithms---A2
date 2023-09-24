package problem3;

public class TreeNode {

    private String name;
    private String firstChild;

    private String rightSibling;

    public TreeNode(String name){
        this.name = name;
    }

    public TreeNode(String name, String firstChild) {
        this.name = name;
        this.firstChild = firstChild;
    }

    public TreeNode(String name, String firstChild, String rightSibling) {
        this.name = name;
        this.firstChild = firstChild;
        this.rightSibling = rightSibling;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstChild(String firstChild) {
        this.firstChild = firstChild;
    }

    public void setRightSibling(String rightSibling) {
        this.rightSibling = rightSibling;
    }

}

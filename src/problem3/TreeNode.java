package problem3;

public class TreeNode {

    private String name;
    private String firstChild;

    private String rightSibling;

    public TreeNode(String name){
        this.name = name;
        this.firstChild = null;
        this.rightSibling = null;
    }


    public void setFirstChild(String firstChild) {
        this.firstChild = firstChild;
    }


    public String getName() {
        return name;
    }

    public void setRightSibling(String rightSibling) {
        this.rightSibling = rightSibling;
    }

}

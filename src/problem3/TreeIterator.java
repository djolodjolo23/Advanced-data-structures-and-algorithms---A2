package problem3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class TreeIterator implements Iterator<TreeNode> {

    private Stack<TreeNode> stack;
    private boolean isPreOrder;

    public TreeIterator(TreeNode root, boolean isPreOrder) {
        this.stack = new Stack<>();
        this.isPreOrder = isPreOrder;
        if (isPreOrder) {
            stack.push(root);
        } else {
            postOrderFix(root);
        }
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        TreeNode currentNode = stack.pop();
        if (isPreOrder) {
            currentNode = stack.pop();
            if (currentNode.rightSibling != null) {
                stack.push(currentNode.rightSibling);
            }
            if (currentNode.firstChild != null) {
                stack.push(currentNode.firstChild);
            }
        }
        return currentNode;
    }

    private void postOrderFix(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderFix(node.rightSibling);
        stack.push(node);
        //postOrderFix(node.rightSibling);
        postOrderFix(node.firstChild);
    }

}

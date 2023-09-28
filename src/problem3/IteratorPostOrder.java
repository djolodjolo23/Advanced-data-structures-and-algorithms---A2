package problem3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class IteratorPostOrder implements Iterator<TreeNode> {

    private Stack<TreeNode> stack;

    public IteratorPostOrder(TreeNode root) {
        this.stack = new Stack<>();
        postOrderFix(root);
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        return stack.pop();
    }

    private void postOrderFix(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderFix(node.rightSibling);
        stack.push(node);
        postOrderFix(node.firstChild);
    }

}

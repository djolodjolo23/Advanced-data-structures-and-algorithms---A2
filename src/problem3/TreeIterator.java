package problem3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class TreeIterator implements Iterator<TreeNode> {

    private Stack<TreeNode> stack;

    public TreeIterator(TreeNode root) {
        stack = new Stack<>();
        stack.push(root);
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
        if (currentNode.rightSibling != null) {
            stack.push(currentNode.rightSibling);
        }
        if (currentNode.firstChild != null) {
            stack.push(currentNode.firstChild);
        }
        return currentNode;
    }


}

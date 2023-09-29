package problem4;

import problem3.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class IteratorPostOrder<AnyType extends Comparable<? super AnyType>> implements Iterator<AnyType> {
    private Stack<BinarySearchTree.BinaryNode<AnyType>> stack;

    private BinarySearchTree.BinaryNode<AnyType> root;

    public IteratorPostOrder(BinarySearchTree<AnyType> bst) {
        this.stack = new Stack<>();
        this.root = bst.root;
        postOrderFix(root);
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public AnyType next() {
        return stack.pop().element;
    }

    private void postOrderFix(BinarySearchTree.BinaryNode<AnyType> node) {
        if (node == null) {
            return;
        }
        postOrderFix(node.right);
        stack.push(node);
        postOrderFix(node.left);
    }
}

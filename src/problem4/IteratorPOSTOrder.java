package problem4;

import java.util.Iterator;
import java.util.Stack;

public class IteratorPOSTOrder<AnyType extends Comparable<? super AnyType>> implements Iterator<AnyType> {
    private Stack<BinarySearchTree.BinaryNode<AnyType>> stack;

    private BinarySearchTree.BinaryNode<AnyType> root;

    public IteratorPOSTOrder(BinarySearchTree<AnyType> bst) {
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
        stack.push(node);
        postOrderFix(node.right);
        postOrderFix(node.left);
    }
}

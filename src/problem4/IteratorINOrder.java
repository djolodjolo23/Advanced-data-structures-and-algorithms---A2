package problem4;

import java.util.Iterator;
import java.util.Stack;

public class IteratorINOrder<AnyType extends Comparable<? super AnyType>> implements Iterator<AnyType> {

    private Stack<BinarySearchTree.BinaryNode<AnyType>> stack;

    private BinarySearchTree.BinaryNode<AnyType> root;

    public IteratorINOrder(BinarySearchTree<AnyType> bst) {
        this.stack = new Stack<>();
        this.root = bst.root;
        inOrderFix(root);
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public AnyType next() {
        return stack.pop().element;
    }

    private void inOrderFix(BinarySearchTree.BinaryNode<AnyType> node) {
        if (node == null) {
            return;
        }
        inOrderFix(node.right);
        stack.push(node);
        inOrderFix(node.left);
    }
}

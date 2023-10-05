package problem4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class IteratorPREOrder<AnyType extends Comparable<? super AnyType>> implements Iterator<AnyType> {
    private Stack<BinarySearchTree.BinaryNode<AnyType>> stack;

    private BinarySearchTree.BinaryNode<AnyType> root;

    public IteratorPREOrder(BinarySearchTree<AnyType> bst) {
        this.stack = new Stack<>();
        root = bst.root;
        stack.push(root);
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public AnyType next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        BinarySearchTree.BinaryNode<AnyType> currentNode = stack.pop();
        if (currentNode.right != null) {
            stack.push(currentNode.right);
        }
        if (currentNode.left != null) {
            stack.push(currentNode.left);
        }
        return currentNode.element;
    }
}

package helpers;

import problem4.BinarySearchTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Iterator for the nodes, used in problem 5 when finding to swap children places.
 * @param <AnyType> can be any data type.
 */
public class NodeIteratorINOrder <AnyType extends Comparable<? super AnyType>> implements Iterator<BinarySearchTree.BinaryNode<AnyType>> {
    private Stack<BinarySearchTree.BinaryNode<AnyType>> stack;

    private BinarySearchTree.BinaryNode<AnyType> root;

    public NodeIteratorINOrder(BinarySearchTree<AnyType> bst) {
        this.stack = new Stack<>();
        this.root = bst.root;
        inOrderFix(root);
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public BinarySearchTree.BinaryNode<AnyType> next() {
        return stack.pop();
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

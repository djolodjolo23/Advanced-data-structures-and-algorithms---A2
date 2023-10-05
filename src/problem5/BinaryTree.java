package problem5;

import problem4.BinarySearchTree;
import helpers.NodeIteratorINOrder;

import java.util.NoSuchElementException;

public class BinaryTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> implements Iterable<AnyType> {


    public BinaryTree(){
    }

    public void swapAllPairsOfChildren() {
        swapAllPairsOfChildren(super.root);
    }


    /**
     * Swap places for all pairs of children nodes.
     */
    private void swapAllPairsOfChildren(BinaryNode<AnyType> node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            BinaryNode<AnyType> tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
        }
        swapAllPairsOfChildren(node.left);
        swapAllPairsOfChildren(node.right);
    }

    /**
     * Using iterator to find the input node.
     * @param x is the input.
     * @return is the binary node, or null.
     */
    private BinaryNode<AnyType> findNodeWithIterator(AnyType x) {
        NodeIteratorINOrder<AnyType> it = new NodeIteratorINOrder<>(this);
        BinaryNode<AnyType> element = null;
        while (it.hasNext()) {
            element = it.next();
            if (element.element == x) {
                break;
            }
        }
        return element;
    }


    /**
     * Swap children of a single input node.
     * @param parentVal is the input node value.
     */
    public void swapChildrenOfASpecificNode(AnyType parentVal) {
        BinaryNode<AnyType> element = findNodeWithIterator(parentVal);
        if (element != null) {
            if (element.left != null && element.right != null) {
                BinaryNode<AnyType> tempNode = element.left;
                element.left = element.right;
                element.right = tempNode;
            } else {
                System.out.println(element.element + "does not have children or have a single child, could not swap places.");
            }
        } else {
            throw new NoSuchElementException("Node not found.");
        }
    }


    /**
     * Move child left or right of a specific input node.
     * @param parentVal is the input node value.
     */
    public void swapChildToLeftOrRight(AnyType parentVal) {
        BinaryNode<AnyType> element = findNodeWithIterator(parentVal);
        if (element != null) {
            if (element.left != null && element.right == null) {
                element.right = element.left;
                element.left = null;
            } else if (element.left == null && element.right != null) {
                element.left = element.right;
                element.right = null;
            } else {
                System.out.println(element.element + " have two children or no children, could not swap places.");
            }
        } else {
            throw new NoSuchElementException("Node not found.");
        }
    }







}

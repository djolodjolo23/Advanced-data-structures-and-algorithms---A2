package problem5;

import problem3.TreeNode;
import problem4.BinarySearchTree;

public class BinaryTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> implements Iterable<AnyType> {


    public BinaryTree(){
    }

    public void switchNodes() {
        switchNodes(super.root);
    }

    private void switchNodes(BinaryNode<AnyType> node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            BinaryNode<AnyType> tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
        }
        switchNodes(node.left);
        switchNodes(node.right);
    }





}

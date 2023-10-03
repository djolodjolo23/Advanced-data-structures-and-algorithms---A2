package problem5;

import problem4.BinarySearchTree;

public class BinaryTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> implements Iterable<AnyType> {


    public BinaryTree(){
    }

    public void switchAllNodes() {
        switchAllNodes(super.root);
    }



    private void switchAllNodes(BinaryNode<AnyType> node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            BinaryNode<AnyType> tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
        }
        switchAllNodes(node.left);
        switchAllNodes(node.right);
    }


    private void switchChildrenOfAParent(AnyType parentVal) {

    }





}

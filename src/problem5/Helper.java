package problem5;

public class Helper<AnyType extends Comparable<? super AnyType>> {



    public boolean checkIfTreesAreIsomorphic(BinaryTree<AnyType> bt1, BinaryTree<AnyType> bt2){
        return checkIfTreesAreIsomorphic(bt1.root, bt2.root);
    }

    private boolean checkIfTreesAreIsomorphic(BinaryTree.BinaryNode<AnyType> bt1, BinaryTree.BinaryNode<AnyType> bt2) {
        if (bt1 == null && bt2 == null) {
            return true; // Both trees are empty, so they are isomorphic
        } else if (bt1 == null || bt2 == null || bt1.element != bt2.element) {
            return false; // If one tree is null or their elements differ, they are not isomorphic
        } else {
            int result = checkIfNodesAreIsomorphic(bt1, bt2);
            if (result == 1) {
                // Recursively check left and right subtrees with swapped conditions
                return checkIfTreesAreIsomorphic(bt1.left, bt2.right) && checkIfTreesAreIsomorphic(bt1.right, bt2.left);
            } else if (result == 2) {
                // Recursively check left and right subtrees with unswapped conditions
                return checkIfTreesAreIsomorphic(bt1.left, bt2.left) && checkIfTreesAreIsomorphic(bt1.right, bt2.right);
            } else return result == -1;
        }
    }


    private int checkIfNodesAreIsomorphic(BinaryTree.BinaryNode<AnyType> bt1, BinaryTree.BinaryNode<AnyType> bt2) {
        // Check if both nodes are null
        if (bt1 == null && bt2 == null) {
            return 0; // Both nodes are null, so they are isomorphic
        } else if (bt1 == null || bt2 == null) {
            return -1; // One node is null, the other is not; they are not isomorphic
        }
        // Check if the elements of the nodes match based on your isomorphism condition
        if (bt1.left != null && bt1.right != null && bt2.left != null && bt2.right != null) {
            if (bt1.left.element == bt2.right.element && bt1.right.element == bt2.left.element) {
                return 1; // Condition 1 is true
            } else if (bt1.left.element == bt2.left.element && bt1.right.element == bt2.right.element) {
                return 2; // Condition 2 is true
            }
        }
        if (bt1.left == null && bt1.right == null && bt2.left == null && bt2.right == null) {
            return -1;
        }
        return 0; // Neither condition holds
    }
}

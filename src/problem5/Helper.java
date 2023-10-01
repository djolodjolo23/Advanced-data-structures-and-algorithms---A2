package problem5;

public class Helper<AnyType extends Comparable<? super AnyType>> {



    public boolean checkIfTreesAreIsomorphic(BinaryTree<AnyType> bt1, BinaryTree<AnyType> bt2){
        return checkIfTreesAreIsomorphic(bt1.root, bt2.root);
    }


    private boolean checkIfTreesAreIsomorphic(BinaryTree.BinaryNode<AnyType> bt1, BinaryTree.BinaryNode<AnyType> bt2) {
        int compare = bt1.element.compareTo(bt2.element);
        if (compare == 0) {

            int compare1 = (bt1.left == null || bt2.left == null) ? -1 : bt1.left.element.compareTo(bt2.left.element);
            int compare2 = (bt1.left == null || bt2.right == null) ? -1 : bt1.left.element.compareTo(bt2.right.element);
            int compare3 = (bt1.right == null || bt2.left == null) ? -1 : bt1.right.element.compareTo(bt2.left.element);
            int compare4 = (bt1.right == null || bt2.right == null) ? -1 : bt1.right.element.compareTo(bt2.right.element);

            if (hasTwoNodes(bt1, bt2)) {
                if (zeroCount(compare1, compare2, compare3, compare4) < 2) {
                    return false; // different sets of nodes, not isomorphic
                }
            }
            if (compare1 == 0) {
                boolean result = checkIfTreesAreIsomorphic(bt1.left, bt2.left);
                if (!result) return false;
            }
            if (compare2 == 0) {
                boolean result = checkIfTreesAreIsomorphic(bt1.left, bt2.right);
                if (!result) return false;
            }
            if (compare3 == 0) {
                boolean result = checkIfTreesAreIsomorphic(bt1.right, bt2.left);
                if (!result) return false;
            }
            if (compare4 == 0) {
                return checkIfTreesAreIsomorphic(bt1.right, bt2.right);
            }
        } else {
            return false;
        }
        return (bt1.left == null || bt2.left != null || bt2.right != null)
                && (bt1.right == null || bt2.left != null || bt2.right != null)
                && (bt2.left == null || bt1.left != null || bt1.right != null)
                && (bt2.right == null || bt1.left != null || bt1.right != null); // if a node exist on one and not on other tree
    }

    private boolean hasTwoNodes(BinaryTree.BinaryNode<AnyType> bt1, BinaryTree.BinaryNode<AnyType> bt2){
        return bt1.left != null && bt1.right != null && bt2.right != null && bt2.left != null;
    }

    private int zeroCount(int compare1, int compare2, int compare3, int compare4) {
        int count = 0;
        if (compare1 == 0) {
            count++;
        }
        if (compare2 == 0) {
            count++;
        }
        if (compare3 == 0) {
            count++;
        }
        if (compare4 == 0) {
            count++;
        }
        return count;
    }

}

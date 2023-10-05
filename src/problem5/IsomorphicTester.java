package problem5;

public class IsomorphicTester<AnyType extends Comparable<? super AnyType>> {



    public boolean testIfTreesAreIsomorphic(BinaryTree<AnyType> bt1, BinaryTree<AnyType> bt2){
        return testIfTreesAreIsomorphic(bt1.root, bt2.root);
    }


    private boolean testIfTreesAreIsomorphic(BinaryTree.BinaryNode<AnyType> bt1, BinaryTree.BinaryNode<AnyType> bt2) {
        if (bt1.element.compareTo(bt2.element) == 0) {
            int compareLL = zeroSafeCompare(bt1.left, bt2.left);
            int compareLR = zeroSafeCompare(bt1.left, bt2.right);
            int compareRL = zeroSafeCompare(bt1.right, bt2.left);
            int compareRR = zeroSafeCompare(bt1.right, bt2.right);;
            if (hasTwoNodes(bt1, bt2) && zeroCount(compareLL, compareLR, compareRL, compareRR) < 2) {
                return false; // different sets of nodes, not isomorphic
            }
            if (zeroCount(compareLL, compareLR, compareRL, compareRR) < 2 && (compareLR == 0 || compareRL == 0 )) {
                return false;   // nodes are the same but on the opposite side, not isomorphic
            }
            if (compareLL == 0) {
                boolean result = testIfTreesAreIsomorphic(bt1.left, bt2.left);
                if (!result) return false;
            }
            if (compareLR == 0) {
                boolean result = testIfTreesAreIsomorphic(bt1.left, bt2.right);
                if (!result) return false;
            }
            if (compareRL == 0) {
                boolean result = testIfTreesAreIsomorphic(bt1.right, bt2.left);
                if (!result) return false;
            }
            if (compareRR == 0) {
                return testIfTreesAreIsomorphic(bt1.right, bt2.right);
            }
        } else {
            return false;
        }
        return nodesExistOnOneButNotOnOther(bt1, bt2); // if a node exist on one and not on other tree, not isomorphic
    }

    private boolean nodesExistOnOneButNotOnOther(BinaryTree.BinaryNode<AnyType> bt1, BinaryTree.BinaryNode<AnyType> bt2) {
        boolean left1Null = bt1.left == null;
        boolean left2NotNull = bt2.left != null;
        boolean right1Null = bt1.right == null;
        boolean right2NotNull = bt2.right != null;

        return (left1Null || left2NotNull || right2NotNull)
                && (right1Null || left2NotNull || right2NotNull)
                && (left2NotNull || left1Null || right1Null)
                && (right2NotNull || left1Null || right1Null);
    }


    private int zeroSafeCompare(BinaryTree.BinaryNode<AnyType> node1, BinaryTree.BinaryNode<AnyType> node2) {
        return (node1 == null || node2 == null) ? -1 : node1.element.compareTo(node2.element);
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

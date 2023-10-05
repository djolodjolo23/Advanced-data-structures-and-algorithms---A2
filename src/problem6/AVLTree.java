package problem6;

import problem4.BinarySearchTree;

public class AVLTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> implements Iterable<AnyType> {


    public AVLTree() {
    }

    public void add(AnyType x) {
        root = balance(super.add(x, root));
    }

    public void remove(AnyType x) {
        balance(super.remove(x, root));
    }



    private BinaryNode<AnyType> balance(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        }
        if (height(t.left) - height(t.right) > 1) {
            if (height(t.left.left) >=height(t.left.right)) {
                t = rotateLeft(t);
            } else {
                t = doubleLeft(t);
            }
        }
        else if (height(t.right) - height(t.left) > 1) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateRight(t);
            } else {
                t = doubleRight(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }



    private BinaryNode<AnyType> rotateLeft(BinaryNode<AnyType> t2){
        BinaryNode<AnyType> t1 = t2.left;
        t2.left = t1.right;
        t1.right = t2;
        t2.height = Math.max(height(t2.left) , height(t2.right)) + 1;
        t1.height = Math.max(height(t1.left), t2.height) + 1;
        return t1;
    }

    private BinaryNode<AnyType> rotateRight(BinaryNode<AnyType> t2) {
        BinaryNode<AnyType> t1 = t2.right;
        t2.right = t1.left;
        t1.left = t2;
        t2.height = Math.max(height(t2.left), height(t2.right)) + 1;
        t1.height = Math.max(height(t1.left), t2.height) + 1;
        return t1;
    }

    private BinaryNode<AnyType> doubleLeft (BinaryNode<AnyType> t) {
        t.left = rotateRight(t.left);
        return rotateLeft(t);
    }

    private BinaryNode<AnyType> doubleRight (BinaryNode<AnyType> t) {
        t.right = rotateLeft(t.right);
        return rotateRight(t);
    }
}

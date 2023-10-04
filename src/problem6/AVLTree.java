package problem6;

import problem4.BinarySearchTree;

public class AVLTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> implements Iterable<AnyType> {


    public static class AVLNode<AnyType> {
        AnyType element;
        AVLNode<AnyType> left;
        AVLNode<AnyType> right;

        int height;

        AVLNode(AnyType element) {
            this(element, null, null);
        }
        AVLNode(AnyType theElement, AVLNode<AnyType> lt, AVLNode<AnyType> rt){
            element = theElement; left = lt; right = rt; height = 0;
        }
    }

    public AVLTree() {
        this.root = null;
    }

    public AVLNode<AnyType> root;
    public void add(AnyType x) {
        root = add(x, root);
    }

    private AVLNode<AnyType> add(AnyType x, AVLNode<AnyType> t) {
        if (t == null) {
            return new AVLNode<>(x, null, null); // no more nodes to traverse
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = add(x, t.left);
        } else if (compareResult > 0) {
            t.right = add(x, t.right);
        }
        return balance(t);
    }

    private AVLNode<AnyType> balance(AVLNode<AnyType> t) {
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
                t = rotateRight(t); // testing
            } else {
                t = doubleRight(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private int height(AVLNode<AnyType> t) {
        if (t == null) {
            return - 1;
        }
        return t.height;
    }

    private AVLNode<AnyType> rotateLeft(AVLNode<AnyType> t2){
        AVLNode<AnyType> t1 = t2.left;
        t2.left = t1.right;
        t1.right = t2;
        t2.height = Math.max(height(t2.left) , height(t2.right)) + 1;
        t1.height = Math.max(height(t1.left), t2.height) + 1;
        return t1;
    }

    private AVLNode<AnyType> rotateRight(AVLNode<AnyType> t2) {
        AVLNode<AnyType> t1 = t2.right;
        t2.right = t1.left;
        t1.left = t2;
        t2.height = Math.max(height(t2.left), height(t2.right)) + 1;
        t1.height = Math.max(height(t1.left), t2.height) + 1;
        return t1;
    }

    private AVLNode<AnyType> doubleLeft (AVLNode<AnyType> t) {
        t.left = rotateRight(t.left);
        return rotateLeft(t);
    }

    private AVLNode<AnyType> doubleRight (AVLNode<AnyType> t) {
        t.left = rotateLeft(t.left);
        return rotateRight(t);
    }
}

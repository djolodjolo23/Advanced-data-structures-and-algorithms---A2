package problem6;

import problem4.BinarySearchTree;

public class AVLTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> {


    public static class AVLNode<AnyType> {
        public AnyType element;
        public BinarySearchTree.BinaryNode<AnyType> left;
        public BinarySearchTree.BinaryNode<AnyType> right;

        AVLNode(AnyType element) {
            this(element, null, null);
        }
        AVLNode(AnyType theElement, BinarySearchTree.BinaryNode<AnyType> lt, BinarySearchTree.BinaryNode<AnyType> rt){
            element = theElement; left = lt; right = rt;
        }
    }

    public BinarySearchTree.BinaryNode<AnyType> root;
    public void add(AnyType x) {
        add(x, root);
    }

    private BinaryNode<AnyType> add(AnyType x, BinaryNode<AnyType> t) {
        return t;
    }
}

package problem6;

import problem4.BinarySearchTree;

public class AVLTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> {


    public void add(AnyType x) {
        add(x, root);
    }

    private BinaryNode<AnyType> add(AnyType x, BinaryNode<AnyType> t) {
        return t;
    }
}

package problem4;

public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{

    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType element) {
            this(element, null, null);
        }
        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
            element = theElement; left = lt; right = rt;
        }
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }


    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        }
        else {
            return true; // match!!
        }
    }

    /*
    Internal method for inserting.
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null); // no more nodes to traverse
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        }
        return t;
    }
}

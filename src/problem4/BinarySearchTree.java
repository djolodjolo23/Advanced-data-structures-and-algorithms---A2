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

    public void add(AnyType x) {
        root = add(x, root);
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        return findMin(root).element;
    }

    public AnyType findMax() {
        return findMax(root).element;
    }

    public void remove(AnyType x) {
        root = remove(x, root);
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
    private BinaryNode<AnyType> add(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null); // no more nodes to traverse
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = add(x, t.left);
        } else if (compareResult > 0) {
            t.right = add(x, t.right);
        }
        return t;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return null; // item not found, do nothing
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }
}

package problem6;
import java.util.Iterator;
import java.util.Stack;

public class IteratorINOrder<AnyType extends Comparable<? super AnyType>> implements Iterator<AnyType> {

    private Stack<AVLTree.AVLNode<AnyType>> stack;

    private AVLTree.AVLNode<AnyType> root;

    public IteratorINOrder(AVLTree<AnyType> avlTree) {
        this.stack = new Stack<>();
        this.root = avlTree.root;
        inOrderFix(root);
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public AnyType next() {
        return stack.pop().element;
    }

    private void inOrderFix(AVLTree.AVLNode<AnyType> node) {
        if (node == null) {
            return;
        }
        inOrderFix(node.right);
        stack.push(node);
        inOrderFix(node.left);
    }
}

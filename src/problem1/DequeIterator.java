package problem1;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DequeIterator<AnyType> implements Iterator<AnyType>{

    private MyDeque<AnyType> deque;
    private MyDeque.Node<AnyType> currentNode;

    public DequeIterator(MyDeque<AnyType> deque) {
        this.deque = deque;
        this.currentNode = deque.head.next;
    }

    @Override
    public boolean hasNext() {
        return currentNode != deque.tail;
    }

    @Override
    public AnyType next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        AnyType data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}

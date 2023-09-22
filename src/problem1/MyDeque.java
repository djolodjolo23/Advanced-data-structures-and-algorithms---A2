package problem1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDeque<AnyType> implements Iterable<AnyType>{

    @Override
    public Iterator<AnyType> iterator() {
        return new DequeIterator<>(this);
    }

    static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        private Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }


    Node<AnyType> head;
    Node<AnyType> tail;

    private int size;
    private int modCount = 0;

    public MyDeque() {
        doClear();
    }

    private void doClear() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
        size = 0;
        modCount++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void addFirst(AnyType x) {
        Node<AnyType> newNode = new Node<>(x, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;

        size++;
        modCount++;
    }


    public void addLast(AnyType x) {
        Node<AnyType> newNode = new Node<>(x, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;

        size++;
        modCount++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty, nothing to remove!");
        } else {
            head.next = head.next.next;
            head.next.prev = head;

            size--;
            modCount++;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty, nothing to remove!");
        } else {
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;

            size--;
            modCount++;
        }
    }

    public int getModCount() {
        return modCount;
    }



}

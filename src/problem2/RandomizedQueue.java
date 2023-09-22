package problem2;

import problem1.MyDeque;

import java.util.Iterator;

public class RandomizedQueue<AnyType> implements Iterable<AnyType>{

    private int[] queue = new int[]{};

    private int size;

    public RandomizedQueue() {
        this.size = 0;
    }

    public void enqueue(int node) {
        int[] newQueue = new int[queue.length + 1];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        newQueue[newQueue.length - 1] = node;
        queue = newQueue;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new RandomizedQueueIterator<>();
    }

    private static class Node<AnyType> {
        public AnyType data;

        private Node(AnyType data) {
            this.data = data;
        }
    }

    public void printQueue() {
        for (int n : queue) {
            System.out.println(n);
        }
    }

}

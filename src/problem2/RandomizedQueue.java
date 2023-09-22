package problem2;

import problem1.MyDeque;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<AnyType> implements Iterable<AnyType>{

    private int[] queue = new int[]{};

    private Random random;

    private int size;

    public RandomizedQueue() {
        this.size = 0;
        random = new Random();
    }

    public void enqueue(int node) {
        int[] newQueue = new int[queue.length + 1];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        newQueue[newQueue.length - 1] = node;
        queue = newQueue;
    }

    public int dequeue() {
        if (queue.length == 0) {
            throw new IllegalStateException("Empty queue, cannot remove an element!");
        }
        int[] newQueue = new int[queue.length - 1];

        int randomIndex = random.nextInt(queue.length);
        int removedElement = queue[randomIndex];
        queue[randomIndex] = queue[queue.length - 1];

        System.arraycopy(queue, 0, newQueue, 0, queue.length - 1); // copying everything except the last one;
        queue = newQueue;
        return removedElement;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new RandomizedQueueIterator<>();
    }


    public void printQueue() {
        for (int n : queue) {
            System.out.println(n);
        }
    }

}

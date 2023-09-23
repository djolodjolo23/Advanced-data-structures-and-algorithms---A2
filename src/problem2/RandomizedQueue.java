package problem2;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue implements Iterable<Integer>{

    private int[] queue = new int[]{};

    private final Random random;

    private int theSize;

    public RandomizedQueue() {
        this.theSize = 0;
        random = new Random();
    }

    public void enqueue(int node) {
        int[] newQueue = new int[queue.length + 1];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        newQueue[newQueue.length - 1] = node;
        queue = newQueue;
        theSize++;
    }

    public int dequeue() {
        if (queue.length == 0) {
            throw new IllegalStateException("Empty queue, cannot remove an element!");
        }
        int[] newQueue = new int[queue.length - 1];

        int randomIndex = random.nextInt(queue.length);
        int removedElement = queue[randomIndex];
        for (int i = 0, j = 0; i < queue.length; i++) {
            if (i != randomIndex) {
                newQueue[j++] = queue[i];
            }
        }
        queue = newQueue;
        theSize--;
        return removedElement;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomizedQueueIterator(this);
    }


    public void printQueue() {
        for (int n : queue) {
            System.out.println(n);
        }
    }

    public int[] getQueue() {
        return queue;
    }

}

package problem2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueueIterator implements Iterator<Integer> {

    private int[] copiedQueue;

    private Random random;

    public RandomizedQueueIterator(RandomizedQueue randomizedQueue) {
        random = new Random();
        copiedQueue = Arrays.copyOf(randomizedQueue.getQueue(), randomizedQueue.size());
    }

    @Override
    public boolean hasNext() {
        return copiedQueue.length > 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (copiedQueue.length == 1) {
            int chosenNum = copiedQueue[0];
            copiedQueue = new int[0]; // when the queue is empty
            return chosenNum;
        } else {
            int randomIndex = random.nextInt(copiedQueue.length);
            int chosenNum = copiedQueue[randomIndex];
            copiedQueue[randomIndex] = copiedQueue[copiedQueue.length - 1];
            copiedQueue = Arrays.copyOf(copiedQueue, copiedQueue.length - 1);
            return chosenNum;
        }
    }

}

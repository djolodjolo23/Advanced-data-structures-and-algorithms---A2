package problem2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueueIterator implements Iterator<Integer> {

    private RandomizedQueue randomizedQueue;
    private int[] copiedQueue;
    private int currentPos;

    private Random random;
    public RandomizedQueueIterator(RandomizedQueue randomizedQueue) {
        random = new Random();
        this.randomizedQueue = randomizedQueue;
        copiedQueue = randomizedQueue.getQueue();
        currentPos = random.nextInt(randomizedQueue.size());
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int currentIndex = random.nextInt(randomizedQueue.size());
        int choosenNum = copiedQueue[currentIndex];

        return choosenNum;
    }
}

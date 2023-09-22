package problem2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        RandomizedQueue rq = new RandomizedQueue();


        rq.enqueue(1);

        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(1);




        rq.printQueue();
        System.out.println();
        int removed = rq.dequeue();
    }


}

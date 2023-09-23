package problem2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        RandomizedQueue rq = new RandomizedQueue();

        rq.enqueue(1);

        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(41);

        Iterator<Integer> it = rq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        //rq.printQueue();
        System.out.println();
        int removed = rq.dequeue();
        int removed2 = rq.dequeue();
    }


}

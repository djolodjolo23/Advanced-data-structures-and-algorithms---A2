package problem2;

public class Main {

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();


        rq.enqueue(1);

        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(1);

        rq.printQueue();
    }


}

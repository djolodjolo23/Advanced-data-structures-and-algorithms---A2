package problem1;

public class Main {

    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();

        deque.addFirst(1);

        deque.addFirst(2);
        deque.addFirst(3);

        deque.addLast(123);

        for (Integer integer : deque) {
            System.out.println(integer);
        }





    }
}

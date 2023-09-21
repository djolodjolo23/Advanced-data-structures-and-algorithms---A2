package problem1;

public class Main {

    public static void main(String[] args) {

        MyDeque <Integer> myDeque = new MyDeque<>();

        myDeque.addFirst(1);

        myDeque.addFirst(2);
        myDeque.addFirst(3);

        myDeque.addLast(123);

        myDeque.removeFirst();

        myDeque.removeLast();






        System.out.println(myDeque.getSize());

    }
}

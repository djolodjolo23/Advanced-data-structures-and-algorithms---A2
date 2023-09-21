package problem1;

public class Main {

    public static void main(String[] args) {

        MyDeque <Integer> myDeque = new MyDeque<>();

        myDeque.addFirst(1);
        myDeque.addLast(2);
        myDeque.addFirst(4);

        System.out.println(myDeque.getSize());

    }
}

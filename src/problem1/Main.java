package problem1;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        MyDeque <Integer> myDeque = new MyDeque<>();

        myDeque.addFirst(1);

        myDeque.addFirst(2);
        myDeque.addFirst(3);

        myDeque.addLast(123);

        for (Integer integer : myDeque) {
            System.out.println(integer);
        }



    }
}

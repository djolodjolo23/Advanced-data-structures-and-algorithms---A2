package helpers;

import problem4.BinarySearchTree;

import java.util.Iterator;

public class PrintStuff<AnyType> {

    public void printIteratorValues(Iterator<AnyType> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
    }

    public void printIsomorphic(boolean isomorphic) {
        System.out.print("Isomorphic? " + isomorphic + ".");
        System.out.println("\n");
    }
}

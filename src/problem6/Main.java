package problem6;

import problem4.BinarySearchTree;

import javax.swing.text.Style;
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        AVLTree<Integer> avlTree = new AVLTree<>();

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        Random random = new Random();


        avlTree.add(3);
        avlTree.add(5);
        avlTree.add(7);
        avlTree.add(4);
        avlTree.add(1);


        while (binarySearchTree.size() <= 10000 && avlTree.size() <= 10000) {
            int insert = random.nextInt(1, 100000);
            if (binarySearchTree.size() <= 10000) {
                binarySearchTree.add(insert);
            }
            if (avlTree.size() <= 10000) {
                avlTree.add(insert);
            }
        }
        System.out.println();


    }
}

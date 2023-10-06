package problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        LetterFrequencyAnalyzer.analyzeFile("demo.txt");

        Map<Character, Integer> letterFrequency = LetterFrequencyAnalyzer.analyzeFile("demo.txt");

        List<Map.Entry<Character, Integer>> letterFrequencySorted = LetterFrequencyAnalyzer.sortMapByValue(letterFrequency);


        for (Map.Entry<Character, Integer> entry : letterFrequencySorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        HuffmanTree huffmanTree = new HuffmanTree();

        huffmanTree.buildTree(letterFrequencySorted);

        System.out.println("iterator:");
        for (HuffmanTree.HuffmanNode n : huffmanTree) {
            System.out.print(n.code + " ");
        }

        System.out.println();
        System.out.println();
        List<Character> characters = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : letterFrequencySorted) {
            characters.add(entry.getKey()); // Extract the character and add it to the 'characters' list
        }

        System.out.println("Get code method:");
        for (Character c : characters) {
            System.out.print(huffmanTree.getCode(c) + " ");
        }



    }
}

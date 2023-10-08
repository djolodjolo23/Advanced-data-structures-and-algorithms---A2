package problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        LetterFrequencyAnalyzer.analyzeFile("plaintext.txt");

        Map<Character, Integer> letterFrequency = LetterFrequencyAnalyzer.analyzeFile("plaintext.txt");

        List<Map.Entry<Character, Integer>> letterFrequencySorted = LetterFrequencyAnalyzer.sortMapByValue(letterFrequency);

        String fullText = LetterFrequencyAnalyzer.getTextInAString("plaintext.txt");


        for (Map.Entry<Character, Integer> entry : letterFrequencySorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        HuffmanTree huffmanTree = new HuffmanTree();

        huffmanTree.buildTree(letterFrequencySorted);

        System.out.println("Iterator:");
        for (HuffmanTree.HuffmanNode n : huffmanTree) {
            System.out.print(n.code + "-" + n.character + " ");
        }


        System.out.println();
        System.out.println();
        List<Character> characters = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : letterFrequencySorted) {
            characters.add(entry.getKey());
        }

        System.out.println("Get code method:");
        for (Character c : characters) {
            System.out.print(huffmanTree.getCode(c) + " ");
        }

        System.out.println();
        System.out.println();



        System.out.println("Full text huffman code bellow.");
        for (int i = 0; i < fullText.length(); i++) {
            char current = fullText.charAt(i);
            System.out.print(huffmanTree.getCode(current));
        }



    }
}

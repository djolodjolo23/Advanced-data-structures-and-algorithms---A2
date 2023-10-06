package problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        LetterFrequencyAnalyzer.analyzeFile("demo.txt");

        Map<Character, Integer> letterFrequency = LetterFrequencyAnalyzer.analyzeFile("demo.txt");

        List<Map.Entry<Character, Integer>> letterFrequencySorted = LetterFrequencyAnalyzer.sortMapByValue(letterFrequency);

        List<Integer> sortedFrequencies = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : letterFrequencySorted) {
            sortedFrequencies.add(entry.getValue());
        }

        for (Map.Entry<Character, Integer> entry : letterFrequencySorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        HuffmanTree huffmanTree = new HuffmanTree();

        huffmanTree.buildTree(sortedFrequencies);


    }
}

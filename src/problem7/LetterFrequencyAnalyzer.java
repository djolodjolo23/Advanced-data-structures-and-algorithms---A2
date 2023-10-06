package problem7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LetterFrequencyAnalyzer {
    public static Map<Character, Integer> analyzeFile(String fileName) {
        Map<Character, Integer> letterFrequency = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase(); // Convert the line to lowercase
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        if (letterFrequency.containsKey(c)) {
                            letterFrequency.put(c, letterFrequency.get(c) + 1);
                        } else {
                            letterFrequency.put(c, 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return letterFrequency;
    }

    public static List<Map.Entry<Character, Integer>> sortMapByValue(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list;
    }
}

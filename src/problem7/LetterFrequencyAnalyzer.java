package problem7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LetterFrequencyAnalyzer {
    public static Map<Character, Integer> analyzeFile(String fileName) {
        Map<Character, Integer> characterFrequency = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int charInt;
            while ((charInt = br.read()) != -1) {
                char c = Character.toLowerCase((char) charInt); // Convert character to lowercase
                if (characterFrequency.containsKey(c)) {
                    characterFrequency.put(c, characterFrequency.get(c) + 1);
                } else {
                    characterFrequency.put(c, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characterFrequency;
    }

    public static String getTextInAString(String fileName) {
        StringBuilder characters = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int charInt;
            while ((charInt = br.read()) != -1) {
                char c = Character.toLowerCase((char) charInt); // Convert character to lowercase
                characters.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters.toString();
    }



    public static List<Map.Entry<Character, Integer>> sortMapByValue(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list;
    }
}

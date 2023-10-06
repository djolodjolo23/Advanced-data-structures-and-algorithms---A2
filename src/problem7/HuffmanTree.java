package problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HuffmanTree {

    public static class HuffmanNode {
        public char character;
        public int frequency;
        public HuffmanNode left;
        public HuffmanNode right;

        public HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        public HuffmanNode(int frequency) {
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
    }

    public HuffmanNode root;


    public void buildTree(List<Map.Entry<Character, Integer>> frequencies) {
        List<HuffmanNode> huffmanNodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> frequency : frequencies) {
            huffmanNodes.add(new HuffmanNode(frequency.getKey(), frequency.getValue()));
        }
        while (huffmanNodes.size() > 1) {
            if (huffmanNodes.size() % 2 == 1) {
                HuffmanNode left = huffmanNodes.remove(0);
                HuffmanNode right = huffmanNodes.remove(0);
                HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency);
                parent.left = left;
                parent.right = right;
                huffmanNodes.add(parent);
            } else {
                if (huffmanNodes.size() == 2) {
                    HuffmanNode left = huffmanNodes.remove(0);
                    HuffmanNode right = huffmanNodes.remove(huffmanNodes.size() - 1);
                    HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency);
                    parent.left = left;
                    parent.right = right;
                    huffmanNodes.add(parent);
                } else {
                    HuffmanNode right = huffmanNodes.remove(0);
                    HuffmanNode left = huffmanNodes.remove(huffmanNodes.size() - 1);
                    HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency);
                    parent.left = left;
                    parent.right = right;
                    huffmanNodes.add(parent);
                }
            }
        }
        this.root = huffmanNodes.get(0);
    }
}

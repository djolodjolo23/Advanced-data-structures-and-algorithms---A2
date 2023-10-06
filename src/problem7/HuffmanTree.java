package problem7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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


    public void buildTree(List<Integer> frequencies) {
        int size = frequencies.size();
        List<HuffmanNode> huffmanNodes = new ArrayList<>();
        for (Integer frequency : frequencies) {
            huffmanNodes.add(new HuffmanNode(frequency));
        }
        while (huffmanNodes.size() > 1) {
            HuffmanNode left = huffmanNodes.remove(0);
            HuffmanNode right = huffmanNodes.remove(0);
            HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            huffmanNodes.add(parent);
            huffmanNodes.sort(Comparator.comparingInt(o -> o.frequency));
        }
        this.root = huffmanNodes.get(0);
    }
}

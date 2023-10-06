package problem7;

import java.util.*;

public class HuffmanTree implements Iterable<HuffmanTree.HuffmanNode> {
    public HuffmanTree() {
        this.codeBuilder = new StringBuilder();
    }

    @Override
    public Iterator<HuffmanNode> iterator() {
        return new MyIterator(this);
    }

    public static class HuffmanNode {
        public char character;
        public int frequency;
        public HuffmanNode left;
        public HuffmanNode right;
        public String code;

        public HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
            this.code = "";
        }

        public HuffmanNode(int frequency) {
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
    }

    public HuffmanNode root;

    private StringBuilder codeBuilder;


    public void buildTree(List<Map.Entry<Character, Integer>> frequencies) {
        List<HuffmanNode> huffmanNodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> frequency : frequencies) {
            huffmanNodes.add(new HuffmanNode(frequency.getKey(), frequency.getValue()));
        }
        while (huffmanNodes.size() > 1) {
            if (huffmanNodes.size() % 2 == 1 || huffmanNodes.size() == 2) {
                HuffmanNode left = huffmanNodes.remove(0);
                HuffmanNode right = huffmanNodes.remove(0);
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
        this.root = huffmanNodes.get(0);
        buildCodes(root);
    }

    public String getCode(char letter) {
        Iterator<HuffmanNode> it = new MyIterator(this);
        HuffmanNode node = null;
        while (it.hasNext()) {
            HuffmanNode temp = it.next();
            if (temp.character == letter) {
                node = temp;
                break;
            }
        }
        if (node == null) {
            throw new NoSuchElementException();
        }
        return node.code;
    }


    private void buildCodes(HuffmanNode root) {
        if (root.left == null && root.right == null) {
            root.code = codeBuilder.toString();
            codeBuilder.deleteCharAt(codeBuilder.length() - 1);
            return;
        }
        if (root.left != null) {
            // check if code null
            codeBuilder.append(0);
            buildCodes(root.left);
        }
        if (root.right != null) {
            codeBuilder.append(1);
            buildCodes(root.right);
        }
        if (!codeBuilder.isEmpty()) {
            codeBuilder.deleteCharAt(codeBuilder.length() - 1);
        }
    }
}

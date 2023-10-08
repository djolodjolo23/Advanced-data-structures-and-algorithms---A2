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


    /**
     * Building tree from the bottom.
     * The nodes build parents either in pair or in tree.
     * If in tree, the first two make parent, and then third is merged to a parent of first two.
     * Therefore, in case currentNodes % 2 != 0 and currentNodes % 3 != 0, remainder nodes two or one are left for the next iteration.
     * @param frequencies are characters and their frequencies.
     */
    public void buildTree(List<Map.Entry<Character, Integer>> frequencies) {
        List<HuffmanNode> huffmanNodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> frequency : frequencies) {
            huffmanNodes.add(new HuffmanNode(frequency.getKey(), frequency.getValue()));
        }
        HuffmanNode remainderNode1 = null;
        HuffmanNode remainderNode2;
        HuffmanNode parentRemainder = null;
        while (huffmanNodes.size() > 1) {
            if (huffmanNodes.size() % 3 == 2 && huffmanNodes.size() % 2 != 0) { // leftover with 2
                remainderNode1 = huffmanNodes.remove(huffmanNodes.size() - 2);
                remainderNode2 = huffmanNodes.remove(huffmanNodes.size() - 1);
                parentRemainder = new HuffmanNode(remainderNode1.frequency + remainderNode2.frequency);
                parentRemainder.left = remainderNode1;
                parentRemainder.right = remainderNode2;
            }
            else if (huffmanNodes.size() % 3 == 1 && huffmanNodes.size() % 2 != 0) { // leftover with one
                remainderNode1 = huffmanNodes.remove(huffmanNodes.size() - 1);
            }
            huffmanNodes = buildRow(huffmanNodes);
            if (parentRemainder != null) {
                huffmanNodes.add(parentRemainder);
                parentRemainder = null;
                remainderNode1 = null;
            } else if (remainderNode1 != null) {
                huffmanNodes.add(remainderNode1);
                remainderNode1 = null;
            }
        }
        this.root = huffmanNodes.remove(0);
        buildCodes(root);
    }


    /**
     * Inner method for building rows.
     * @param huffmanNodes are the current nodes.
     * @return new list with parent nodes, from the merged huffman nodes.
     */
    private List<HuffmanNode> buildRow(List<HuffmanNode> huffmanNodes) {
        List<HuffmanNode> parents = new ArrayList<>();
        if (huffmanNodes.size() % 2 == 0) {
            while (!huffmanNodes.isEmpty()) {
                HuffmanNode left = huffmanNodes.remove(0);
                HuffmanNode right = huffmanNodes.remove(0);
                HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency);
                parent.left = left;
                parent.right = right;
                parents.add(parent);
            }
        } else {
            while (!huffmanNodes.isEmpty()) {
                HuffmanNode left = huffmanNodes.remove(0);
                HuffmanNode right = huffmanNodes.remove(0);
                HuffmanNode rightRight = huffmanNodes.remove(0);
                HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency);
                parent.left = left;
                parent.right = right;
                HuffmanNode parentParent = new HuffmanNode(parent.frequency + rightRight.frequency);
                parentParent.left = parent;
                parentParent.right = rightRight;
                parents.add(parentParent);
            }
        }
        return parents;
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

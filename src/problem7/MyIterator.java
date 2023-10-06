package problem7;

import java.util.*;

public class MyIterator implements Iterator<HuffmanTree.HuffmanNode> {
    private Stack<HuffmanTree.HuffmanNode> stack;

    private HuffmanTree.HuffmanNode root;

    public MyIterator(HuffmanTree huffmanTree) {
        this.stack = new Stack<>();
        root = huffmanTree.root;
        stack.push(root);
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public HuffmanTree.HuffmanNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        while (!stack.isEmpty()) {
            HuffmanTree.HuffmanNode currentNode = stack.pop();
            if (currentNode.right == null && currentNode.left == null) {
                // If the current node is a bottom node, return it
                return currentNode;
            }
            // Push the child nodes onto the stack for further exploration
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        // If we reach this point, there are no more bottom nodes
        throw new NoSuchElementException();
    }
}
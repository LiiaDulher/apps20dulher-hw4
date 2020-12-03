package ua.edu.ucu.tries;

import ua.edu.ucu.queue.Queue;

public class RWayTrie implements Trie {

    private static final int R = 26;
    private Node root = new Node(0);
    private int size = 0;

    private static class Node {
        private int number;
        private Node[] next = new Node[R];

        Node(int num) {
            number = num;
            for (int i = 0; i < next.length; i++) {
                next[i] = null;
            }
        }

        public int getValue() {
            return number;
        }

        public Node getNext(char key) {
            return next[(int) key - (int) 'a'];
        }

        public Node getNext(int key) {
            return next[key];
        }

        public void setNext(char key, Node nextNode) {
            next[(int) key - (int) 'a'] = nextNode;
        }

        public void setNumber(int num) {
            number = num;
        }

        public boolean hasNext() {
            for (int i = 0; i < next.length; i++) {
                if (next[i] != null) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void add(Tuple t) {
        String word = t.term;
        if (contains(word)) {
            return;
        }
        size++;
        Node currentNode = root;
        for (int i = 0; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            if (currentNode.getNext(c) == null) {
                currentNode.setNext(c, new Node(0));
            }
            currentNode = currentNode.getNext(c);
        }
        char c = word.charAt(word.length() - 1);
        if (currentNode.getNext(c) == null) {
            currentNode.setNext(c, new Node(t.weight));
        } else {
            currentNode.getNext(c).setNumber(t.weight);
        }
    }

    @Override
    public boolean contains(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (currentNode.getNext(c) == null) {
                return false;
            }
            currentNode = currentNode.getNext(c);
        }
        return currentNode.getValue() != 0;
    }

    @Override
    public boolean delete(String word) {
        if (!contains(word)) {
            return false;
        }
        size--;
        Node finishNode = root;
        char key = word.charAt(0);
        Node currentNode = root.getNext(key);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (currentNode.getValue() != 0) {
                finishNode = currentNode;
                key = word.charAt(i);
            }
            currentNode = currentNode.getNext(c);
        }
        if (currentNode.hasNext()) {
            currentNode.setNumber(0);
        } else {
            finishNode.setNext(key, null);
        }
        return true;
    }

    @Override
    public Iterable<String> words() {
        return wordsWithPrefix("");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        Node startNode = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (startNode.getNext(c) == null) {
                return new Queue();
            }
            startNode = startNode.getNext(c);
        }
        Queue q = new Queue();
        collect(startNode, s, q);
        return q;
    }

    private void collect(Node x, String pre, Queue q) {
        if (x == null) {
            return;
        }
        if (x.getValue() != 0) {
            q.enqueue(pre);
        }
        for (int c = 0; c < R; c++) {
            char symbol = (char) ((int) 'a' + c);
            collect(x.getNext(c), pre + symbol, q);
        }
    }

    @Override
    public int size() {
        return size;
    }

}

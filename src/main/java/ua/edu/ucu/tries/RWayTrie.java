package ua.edu.ucu.tries;

import ua.edu.ucu.queue.Queue;

public class RWayTrie implements Trie {

    private static final int R = 26;
    private Node root = new Node(0);

    private static class Node {
        private int number;
        private Node[] next = new Node[R];

        public Node(int num){
            number = num;
            for (int i = 0; i < next.length; i++) {
                next[i] = null;
            }
        }

        public int getValue() {
            return number;
        }

        public Node getNext(char key) {
            return next[(int)key - (int)'a'];
        }

        public Node getNext(int key) {
            return next[key];
        }

        public void setNext(char key, Node nextNode) {
            next[(int)key - (int)'a'] = nextNode;
        }

        public void setNumber(int num) {
            number = num;
        }

        public boolean hasNext() {
            for (int i = 0; i < next.length; i++) {
                if (next[i] != null){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void add(Tuple t) {
        String word = t.term;
        Node currentNode = root;
        for (int i = 0; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            if (currentNode.getNext(c) == null) {
                currentNode.setNext(c, new Node(0));
            }
            currentNode = currentNode.getNext(c);
        }
        char c = word.charAt(word.length() - 1);
        if (currentNode.getNext(c) == null){
            currentNode.setNext(c, new Node(t.weight));
        } else {
            currentNode.setNumber(t.weight);
        }
        // throw new UnsupportedOperationException("Not supported yet.");
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
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(String word) {
        if (!contains(word)){
            return false;
        }
        Node currentNode = root;
        Node finishNode = root;
        char key = word.charAt(0);
        for (int i = 0; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            if (currentNode.getValue() != 0) {
                finishNode = currentNode;
                key = c;
            }
            currentNode = currentNode.getNext(c);
        }
        char c = word.charAt(word.length() - 1);
        if (currentNode.getNext(c).hasNext()){
            currentNode.setNumber(0);
        } else {
            finishNode.setNext(key, null);
        }
        return true;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> words() {
        return wordsWithPrefix("");
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        Node startNode = root;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (startNode.getNext(c) == null){
                return null;
            }
            startNode = startNode.getNext(c);
        }
        Queue q = new Queue();
        collect(root, s, q);
        // todo write
        return q;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    private void collect(Node x, String pre, Queue q)
    {
        if (x == null) {
            return;
        }
        if (x.getValue() != 0) {
            q.enqueue(pre);
        }
        for (int c = 0; c < R; c++) {
            char symbol = (char)((int)'a' + c);
            collect(x.getNext(c), pre + symbol, q);
        }
    }

    @Override
    public int size() {
        Iterable<String> allWords = words();
        int len = 0;
        while(allWords.iterator().hasNext()) {
            len++;
            allWords.iterator().next();
        }
        return  len;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

}

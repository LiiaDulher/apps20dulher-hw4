package ua.edu.ucu.autocomplete;

import ua.edu.ucu.queue.Queue;
import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.Collections;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public int load(String... strings) {
        for (String str: strings){
            String[] words = {str};
            if (str.contains(" ")) {
               words = str.split(" ");
            }
            for (String word: words) {
                if (word.length() > 2){
                    trie.add(new Tuple(word, word.length()));
                }
            }
        }
        return size();
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean contains(String word) {
        return trie.contains(word);
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean delete(String word) {
        return trie.delete(word);
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        if (pref.length() < 2) {
            return new Queue() ;
        }
        return trie.wordsWithPrefix(pref);
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        if (pref.length() < 2) {
            return Collections.emptyList() ;
        }
        Iterable<String> allWords = wordsWithPrefix(pref);
        Queue kWords = new Queue();
        if (k > 0) {
            int len = pref.length() + k;
            if (pref.length() == 2){
                len++;
            }
            for (String str : allWords) {
                if (str.length() < len){
                    kWords.enqueue(str);
                }
            }
        }
        return kWords;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public int size() {
        return trie.size();
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}

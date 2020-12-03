package ua.edu.ucu.tries;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RWayTrieTest {

    // testing add()

    @Test
    public void testAddShorterWord(){
        RWayTrie tree = new RWayTrie();
        tree.add(new Tuple("abcd", 4));
        tree.add(new Tuple("abc", 3));
    }

    // testing delete()

    @Test
    public void testDeleteShorterWord(){
        RWayTrie tree = new RWayTrie();
        tree.add(new Tuple("abcd", 4));
        tree.add(new Tuple("abc", 3));
        tree.delete("abcd");
        
        boolean actualResult = tree.contains("abc");

        assertTrue(actualResult);
    }

    // testing words()

    @Test
    public void testWords() {
        RWayTrie tree = new RWayTrie();
        String[] words = {"abc", "abce", "abcd", "abcde", "abcdef"};
        for (String word: words) {
            tree.add(new Tuple(word, word.length()));
        }

        Iterable<String> actualResult = tree.words();

        String[] expResult = {"abc", "abce", "abcd", "abcde", "abcdef"};

        assertThat(actualResult, containsInAnyOrder(expResult));
    }

    // testing wordsWithPrefix()

    @Test
    public void testNoSuchPrefix(){
        RWayTrie tree = new RWayTrie();
        String[] words = {"abc", "abce", "abcd", "abcde", "abcdef"};
        for (String word: words) {
            tree.add(new Tuple(word, word.length()));
        }
        Iterable<String> actualResult = tree.wordsWithPrefix("ba");

        String[] expResult = {};

        assertThat(actualResult, containsInAnyOrder(expResult));
    }
}

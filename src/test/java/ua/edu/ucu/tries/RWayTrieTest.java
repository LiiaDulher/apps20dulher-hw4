package ua.edu.ucu.tries;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class RWayTrieTest {

    // testing words()

    @Ignore
    @Test
        public void testWords() {
        RWayTrie tree = new RWayTrie();
        String[] words = {"ab", "abce", "abcd", "abcde", "abcdef"};
        for (String word: words) {
            tree.add(new Tuple(word, word.length()));
        }

        Iterable<String> actualResult = tree.words();

        String[] expResult = {"abc", "abce", "abcd", "abcde"};

        assertThat(actualResult, containsInAnyOrder(expResult));
    }
}

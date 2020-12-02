package ua.edu.ucu.autocomplete;

import org.junit.Ignore;
import org.junit.Test;
import ua.edu.ucu.tries.RWayTrie;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class PrefixMatchesTest {

    // testing constructor

    @Test
    public void testConstructor() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("ab", "abce", "abcd", "abcde", "abcdef");

        boolean actualResult = pm.contains("ab");

        assertFalse(actualResult);
    }

    @Test
    public void testConstructorSize() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        int expResult = 4;

        int actualResult = pm.load("ab", "abce", "abcd", "abcde", "abcdef");

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testConstructorLine() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        int expResult = 6;

        int actualResult = pm.load("abc", "abce jhg", "abcd", "abcde", "abcdef");


        assertEquals(expResult, actualResult);
    }

    // testing load()

    @Test
    public void testLoadAlreadyContains() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        int expResult = 4;

        int actualResult = pm.load("abce", "abce", "abcd", "abcde", "abcdef");

        assertEquals(expResult, actualResult);
    }

    // testing contains()

    @Test
    public void testContainsTrue() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");

        boolean actualResult = pm.contains("abce");

        assertTrue(actualResult);
    }

    @Test
    public void testContainsFalse() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");

        boolean actualResult = pm.contains("abced");

        assertFalse(actualResult);
    }

    @Test
    public void testContainsPart() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef", "abcfg");

        boolean actualResult = pm.contains("abcf");

        assertFalse(actualResult);
    }

    // testing delete()

    @Test
    public void testDeleteFalse() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");

        boolean actualResult = pm.delete("abced");

        assertFalse(actualResult);
    }

    @Test
    public void testDeleteTrue() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");

        boolean actualResult = pm.delete("abce");

        assertTrue(actualResult);
    }

    @Test
    public void testDeleteNotContains() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");

        pm.delete("abce");
        boolean actualResult = pm.contains("abce");

        assertFalse(actualResult);
    }

    @Test
    public void testDeletePref() {
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");

        pm.delete("abc");
        boolean actualResult = pm.contains("abce");

        assertTrue(actualResult);
    }

    // testing wordsWithPrefix(pref)

    @Ignore
    @Test
    public void testWordsWithTooShortPrefixString() {
        String pref = "a";
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");
        Iterable<String> result = pm.wordsWithPrefix(pref);

        String[] expResult = {};

        assertThat(result, containsInAnyOrder(expResult));
    }

    // testing wordsWithPrefix(pref, k)

    @Ignore
    @Test
    public void testWordsWithPrefixStringAndWrongK() {
        String pref = "abc";
        int k = 0;
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");
        Iterable<String> result = pm.wordsWithPrefix(pref, k);

        String[] expResult = {};

        assertThat(result, containsInAnyOrder(expResult));
    }

    @Ignore
    @Test
    public void testWordsWithPrefixString() {
        String pref = "ab";
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");
        int k = 4;
        Iterable<String> result = pm.wordsWithPrefix(pref, k);

        String[] expResult = {"abc", "abce", "abcd", "abcde", "abcdef"};

        assertThat(result, containsInAnyOrder(expResult));
    }
}

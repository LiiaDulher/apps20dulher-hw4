package ua.edu.ucu.autocomplete;

import org.junit.Ignore;
import org.junit.Test;
import ua.edu.ucu.tries.RWayTrie;

import static org.junit.Assert.*;

public class PrefixMatchesTest {

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
}

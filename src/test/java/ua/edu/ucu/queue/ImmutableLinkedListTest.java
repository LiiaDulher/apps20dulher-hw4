package ua.edu.ucu.queue;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    // testing add(Object)

    @Test
    public void testImmutableAdd() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String s = "7";
        ImmutableLinkedList arr1 = arr.add(s);
        assertNotSame(arr, arr1);
    }

    @Test
    public void testEmptyLinkedListAdd() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String s = "7";
        ImmutableLinkedList arr1 = arr.add(s);

        String[] expResult ={"7"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementLinkedListAdd() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String s2 = "10";
        ImmutableLinkedList arr1 = arr.add(s2);

        String[] expResult ={"5", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAdd() {
        String[] s1 = {"5", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String s2 =  "10";
        ImmutableLinkedList arr1 = arr.add(s2);

        String[] expResult ={"5", "12", "10"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing add(index, Object)

    @Test
    public void testImmutableIndexAdd() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String s = "7";
        ImmutableLinkedList arr1 = arr.add(0, s);
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeIndexAdd() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String s = "7";
        ImmutableLinkedList arr1 = arr.add(12, s);
    }

    @Test
    public void testOneElementLinkedListIndexAdd() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String s2 = "7";
        ImmutableLinkedList arr1 = arr.add(0, s2);

        String[] expResult ={"7", "5"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexAdd() {
        String[] s1 = {"5", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String s2 = "7";
        ImmutableLinkedList arr1 = arr.add(1, s2);

        String[] expResult ={"5", "7", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing addAll(Object[])

    @Test
    public void testImmutableAddAll() {
        String[] s1 = {};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String[] s = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(s);
        assertNotSame(arr, arr1);
    }

    @Test
    public void testEmptyLinkedListAddAll() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String[] s = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(s);

        String[] expResult ={"7", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementLinkedListAddAll() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String[] s2 = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(s2);

        String[] expResult ={"5", "7", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddAll() {
        String[] s1 = {"5", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String[] s2 = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(s2);

        String[] expResult ={"5", "12", "7", "10"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing addAll(index, Object[])

    @Test
    public void testImmutableIndexAddAll() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String[] s = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(0, s);
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testBigIndexOutOfRangeIndexAddAll() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String[] s = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(12, s);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSmallIndexOutOfRangeIndexAddAll() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String[] s = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(-1, s);
    }

    @Test
    public void testOneElementLinkedListIndexAddAll() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String[] s2 = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(1, s2);

        String[] expResult ={"5", "7", "10"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testIndexAddAll() {
        String[] s1 = {"5", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String[] s2 = {"7", "10"};
        ImmutableLinkedList arr1 = arr.addAll(1, s2);

        String[] expResult ={"5", "7", "10", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing get()

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeGet() {
        String[] s = {"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        Object s1 = arr.get(12);
    }

    @Test
    public void testOneElementLinkedListGet() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        String expResult ="5";
        Object actualResult = arr.get(0);

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGet() {
        String[] s1 = {"5", "7", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        String expResult = "10";
        Object actualResult = arr.get(2);
        assertEquals(expResult, actualResult);
    }

    // testing remove()

    @Test
    public void testImmutableRemove() {
        String[] s ={"7"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.remove(0);
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfRangeRemove() {
        String[] s = {"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.remove(2);
    }

    @Test
    public void testOneElementLinkedListRemove() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.remove(0);

        String[] expResult =new String[0] ;
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testRemove() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.remove(1);

        String[] expResult ={"5", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing set()

    @Test
    public void testImmutableSet() {
        String[] s ={"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.set(1, "15");
        assertNotSame(arr, arr1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testBigIndexOutOfRangeSet() {
        String[] s = {"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        arr.set(2, "18");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSmallIndexOutOfRangeSet() {
        String[] s = {"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        arr.set(-1, "18");
    }

    @Test
    public void testOneElementLinkedListSet() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.set(0, "98");

        String[] expResult = {"98"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testSet() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.set(1, "7");

        String[] expResult ={"5", "7", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing indexOf()

    @Test
    public void testNoElementIndexOf() {
        String[] s1 = {"5", "7"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        int expResult = -1;
        int actualResult = arr.indexOf("10");

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        String[] s1 = {"5", "7", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        int expResult = 2;
        int actualResult = arr.indexOf("10");
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSameIndexOf() {
        String[] s1 = {"5", "7", "7", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        int expResult = 1;
        Object actualResult = arr.indexOf("7");
        assertEquals(expResult, actualResult);
    }

    // testing size()

    @Test
    public void testEmptyLinkedListSize() {
        ImmutableLinkedList arr = new ImmutableLinkedList();

        int expResult = 0;
        int actualResult = arr.size();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testSize() {
        String[] s1 = {"5", "7", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        int expResult = 4;
        int actualResult = arr.size();
        assertEquals(expResult, actualResult);
    }

    // testing clear()

    @Test
    public void testImmutableClear() {
        String[] s ={"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.clear();
        assertNotSame(arr, arr1);
    }


    @Test
    public void testClear() {
        String[] s1 = {"5", "7"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.clear();

        String[] expResult = new String[0];
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    // testing isEmpty()

    @Test
    public void testEmptyLinkedListIsEmpty() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        assertTrue(arr.isEmpty());
    }


    @Test
    public void testisEmpty() {
        String[] s1 = {"5", "7"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        assertFalse(arr.isEmpty());
    }

    // testing toArray()

    @Test
    public void testEmptyLinkedListToArray() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String[] expResult = new String[0];
        Object[] actualResult = arr.toArray();
        assertArrayEquals(expResult, actualResult);
    }


    @Test
    public void testToArray() {
        String[] s1 = {"5", "7"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String[] expResult = {"5", "7"};
        Object[] actualResult = arr.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing toString()

    @Test
    public void testEmptyLinkedListToString() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        String expResult = "\n";
        String actualResult = arr.toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementLinkedListToString() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String expResult = "5 \n";
        String actualResult = arr.toString();
        assertEquals(expResult, actualResult);
    }


    @Test
    public void testToString() {
        String[] s1 = {"5", "7", "78"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        String expResult = "5 7 78 \n";
        String actualResult = arr.toString();
        assertEquals(expResult, actualResult);
    }

    // testing addFirst()

    @Test
    public void testImmutableAddFirst() {
        String[] s ={"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.addFirst("15");
        assertNotSame(arr, arr1);
    }

    @Test
    public void testEmptyLinkedListAddFirst() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        ImmutableLinkedList arr1 = arr.addFirst("98");

        String[] expResult = {"98"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementLinkedListAddFirst() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.addFirst("98");

        String[] expResult = {"98", "5"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddFirst() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.addFirst("7");

        String[] expResult ={"7", "5", "10", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing addLast()

    @Test
    public void testImmutableAddLast() {
        String[] s ={"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.addLast("15");
        assertNotSame(arr, arr1);
    }

    @Test
    public void testEmptyLinkedListAddLast() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        ImmutableLinkedList arr1 = arr.addLast("98");

        String[] expResult = {"98"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testOneElementLinkedListAddLast() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.addLast("98");

        String[] expResult = {"5", "98"};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testAddLast() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.addLast("7");

        String[] expResult ={"5", "10", "12", "7"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing getFirst()

    @Test(expected = NullPointerException.class)
    public void testNullPointerGetFirst() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        arr.getFirst();
    }

    @Test
    public void testOneElementLinkedListGetFirst() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        String expResult = "5";
        Object actualResult = arr.getFirst();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGetFirst() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        String expResult = "5";
        Object actualResult = arr.getFirst();
        assertEquals(expResult, actualResult);
    }

    // testing getLast()

    @Test(expected = NullPointerException.class)
    public void testNullPointerGetLast() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        arr.getLast();
    }

    @Test
    public void testOneElementLinkedListGetLast() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        String expResult = "5";
        Object actualResult = arr.getLast();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testGetLast() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);

        String expResult = "12";
        Object actualResult = arr.getLast();
        assertEquals(expResult, actualResult);
    }

    // testing removeFirst()

    @Test
    public void testImmutableRemoveFirst() {
        String[] s ={"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.removeFirst();
        assertNotSame(arr, arr1);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyLinkedListRemoveFirst() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        arr.removeFirst();
    }

    @Test
    public void testOneElementLinkedListRemoveFirst() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.removeFirst();

        String[] expResult = {};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testRemoveFirst() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.removeFirst();

        String[] expResult ={"10", "12"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }

    // testing removeLast()

    @Test
    public void testImmutableRemoveLast() {
        String[] s ={"7", "10"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s);
        ImmutableLinkedList arr1 = arr.removeLast();
        assertNotSame(arr, arr1);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyLinkedListRemoveLast() {
        ImmutableLinkedList arr = new ImmutableLinkedList();
        arr.removeLast();
    }

    @Test
    public void testOneElementLinkedListRemoveLast() {
        String[] s1 = {"5"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.removeLast();

        String[] expResult = {};
        Object[] actualResult = arr1.toArray();

        assertArrayEquals(expResult, actualResult);
    }

    @Test
    public void testRemoveLast() {
        String[] s1 = {"5", "10", "12"};
        ImmutableLinkedList arr = new ImmutableLinkedList(s1);
        ImmutableLinkedList arr1 = arr.removeLast();

        String[] expResult ={"5", "10"};
        Object[] actualResult = arr1.toArray();
        assertArrayEquals(expResult, actualResult);
    }
}

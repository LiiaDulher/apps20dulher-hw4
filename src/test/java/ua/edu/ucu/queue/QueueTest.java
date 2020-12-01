package ua.edu.ucu.queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    //testing peek()

    @Test(expected = NullPointerException.class)
    public void testEmptyQueuePeek() {
        Queue q = new Queue();
        q.peek();
    }

    @Test
    public void testOneElementQueuePeek() {
        Queue q = new Queue();
        q.enqueue("7");
        String expResult = "7";

        Object actualResult = q.peek();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testPeek() {
        Queue q = new Queue();
        q.enqueue("7");
        q.enqueue("8");
        q.enqueue("15");
        String expResult = "7";

        Object actualResult = q.peek();

        assertEquals(expResult, actualResult);
    }

    //testing dequeue()

    @Test(expected = NullPointerException.class)
    public void testEmptyQueueDequeue() {
        Queue q = new Queue();
        q.dequeue();
    }

    @Test
    public void testOneElementQueueDequeue() {
        Queue q = new Queue();
        q.enqueue("7");
        String expResult = "7";

        Object actualResult = q.dequeue();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testFirstAfterDequeue() {
        Queue q = new Queue();
        q.enqueue("7");
        q.enqueue("8");
        q.enqueue("15");
        String expResult = "8";

        q.dequeue();
        Object actualResult = q.peek();

        assertEquals(expResult, actualResult);
    }

    @Test
    public void testDeletedDequeue() {
        Queue q = new Queue();
        q.enqueue("7");
        q.enqueue("8");
        q.enqueue("15");
        String expResult = "7";

        Object actualResult = q.dequeue();

        assertEquals(expResult, actualResult);
    }

    // testing enqueue()

    @Test
    public void testEmptyQueueEnqueue() {
        Queue q = new Queue();
        q.enqueue("7");
    }

    @Test
    public void testEnqueue() {
        Queue q = new Queue();
        q.enqueue("7");
        q.enqueue("10");
    }
}

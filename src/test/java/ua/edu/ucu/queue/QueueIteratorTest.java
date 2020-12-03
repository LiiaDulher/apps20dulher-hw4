package ua.edu.ucu.queue;

import org.junit.Test;

import java.util.NoSuchElementException;

public class QueueIteratorTest {

    // testing next()
    
    @Test(expected = NoSuchElementException.class)
    public void testEmptyQueuePeek() {
        Queue q = new Queue();
        q.iterator().next();
    }
}

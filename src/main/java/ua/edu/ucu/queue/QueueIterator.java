package ua.edu.ucu.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueIterator implements Iterator {
    private int current;
    private ImmutableLinkedList queue;

    public QueueIterator(ImmutableLinkedList queue) {
        current = 0;
        this.queue = queue;
    }

    @Override
    public boolean hasNext() {
        return queue.size() > current;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Object data = queue.get(current);
            current++;
            return data;
        }
        throw new NoSuchElementException();
    }
}

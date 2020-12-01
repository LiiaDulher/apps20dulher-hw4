package ua.edu.ucu.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue implements Iterable {
    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object element = peek();
        queue = queue.removeFirst();
        return element;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator {
        private int current;

        public QueueIterator() {
            current = 0;
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
}

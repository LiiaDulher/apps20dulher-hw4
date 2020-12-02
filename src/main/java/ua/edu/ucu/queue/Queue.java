package ua.edu.ucu.queue;

import java.util.Iterator;

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
        return new QueueIterator(this.queue);
    }
}

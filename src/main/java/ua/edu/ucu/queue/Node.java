package ua.edu.ucu.queue;

public class Node {
    private Object value;
    private Node next = null;

    public Node(Object e) {
        value = e;
    }

    public void setValue(Object e) {
        value = e;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node copy() {
        Node startNode = new Node(value);
        Node curNode = this;
        Node newNode = startNode;
        while (curNode.next != null) {
            curNode = curNode.getNext();
            newNode.setNext(new Node(curNode.getValue()));
            newNode = newNode.getNext();
        }
        return startNode;
    }
}

package academy.pocu.comp3500.lab2;

import academy.pocu.comp3500.lab2.datastructure.Node;

public final class Queue {
    private Node head = null;
    private Node tail = null;
    private int size;

    public void enqueue(final int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;
        ++size;
    }

    public int peek() {
        return head.getData();
    }

    public int dequeue() {
        int peek = peek();
        head = LinkedList.removeAt(head, 0);

        --size;

        return peek;
    }

    public int getSize() {
        return size;
    }
}
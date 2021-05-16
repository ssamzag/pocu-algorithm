package academy.pocu.comp3500.lab2;

import academy.pocu.comp3500.lab2.datastructure.Node;

public final class Queue {
    private Node head = null;
    private Node tail = null;
    private int size;

    public void enqueue(final int data) {
        ++size;
        if (head == null) {
            head = LinkedList.prepend(null, data);
            tail = head;
        } else {
            Node node = new Node(data);
            tail.setNext(node);
            tail = node;
        }
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
package academy.pocu.comp3500.lab2;

import academy.pocu.comp3500.lab2.datastructure.Node;

public final class Queue {
    private Node head = null;
    private Node tail = null;
    private int size;

    public void enqueue(final int data) {
        ++size;
        if (head == null) {
            head = LinkedList.append(null, data);
            tail = head;
            return;
        }
        tail = LinkedList.append(tail, data);
    }

    public int peek() {
        return head.getData();
    }

    public int dequeue() {
        int dequeue = head.getData();
        head = LinkedList.removeAt(head, 0);

        --size;

        return dequeue;
    }

    public int getSize() {
        return size;
    }
}
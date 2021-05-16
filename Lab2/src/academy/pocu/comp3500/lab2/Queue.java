package academy.pocu.comp3500.lab2;

import academy.pocu.comp3500.lab2.datastructure.Node;

public final class Queue {
    private Node queue;
    private int size;

    public void enqueue(final int data) {
        queue = LinkedList.prepend(queue, data);
        ++size;
    }

    public int peek() {
        return LinkedList.getOrNull(queue, size - 1).getData();
    }

    public int dequeue() {
        int dequeue = LinkedList.getOrNull(queue, size - 1).getData();
        queue = LinkedList.removeAt(queue, size - 1);
        --size;

        return dequeue;
    }

    public int getSize() {
        return size;
    }
}
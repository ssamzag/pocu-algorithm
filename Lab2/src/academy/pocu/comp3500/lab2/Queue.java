package academy.pocu.comp3500.lab2;

import academy.pocu.comp3500.lab2.datastructure.Node;

public final class Queue {
    private Node queue;
    private int size;

    public void enqueue(final int data) {
        queue = LinkedList.append(queue, data);
        ++size;
    }

    public int peek() {
        return queue.getData();
    }

    public int dequeue() {
        int dequeue = queue.getData();
        queue = LinkedList.removeAt(queue, 0);
        --size;

        return dequeue;
    }

    public int getSize() {
        return size;
    }
}
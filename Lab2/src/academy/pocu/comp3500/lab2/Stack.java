package academy.pocu.comp3500.lab2;

import academy.pocu.comp3500.lab2.datastructure.Node;

public class Stack {
    private Node stack;
    private int size;

    public void push(final int data) {
        stack = LinkedList.prepend(stack, data);
        size++;
    }

    public int peek() {
        return stack.getData();
    }

    public int pop() {
        int stackPop = peek();
        stack = LinkedList.removeAt(stack, 0);
        size--;
        return stackPop;
    }

    public int getSize() {
        return size;
    }
}

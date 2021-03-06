package academy.pocu.comp3500.lab2.app;

import academy.pocu.comp3500.lab2.LinkedList;
import academy.pocu.comp3500.lab2.datastructure.Node;
import academy.pocu.comp3500.lab2.Queue;
import academy.pocu.comp3500.lab2.Stack;

public class Program {

    public static void main(String[] args) {
        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.append(root, 11);
            root = LinkedList.append(root, 12);

            assert (root.getData() == 10);

            Node next = root.getNextOrNull();

            assert (next.getData() == 11);

            next = next.getNextOrNull();

            assert (next.getData() == 12);
        }

        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.prepend(root, 11);

            assert (root.getData() == 11);

            root = LinkedList.prepend(root, 12);

            assert (root.getData() == 12);

            Node next = root.getNextOrNull();

            assert (next.getData() == 11);

            next = next.getNextOrNull();

            assert (next.getData() == 10);
        }

        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.insertAt(root, 0, 11);

            assert (root.getData() == 11);

            root = LinkedList.insertAt(root, 1, 12);

            assert (root.getData() == 11);

            Node next = root.getNextOrNull();

            assert (next.getData() == 12);

            root = LinkedList.insertAt(root, 1, 55);

            next = root.getNextOrNull();

            assert (next.getData() == 55);

            root = LinkedList.insertAt(root, 14, 12);
            root = LinkedList.insertAt(root, -1, 12);
        }

        {

            var root = LinkedList.insertAt(null, 0, 11);
            assert (root.getData() == 11);

            root = LinkedList.insertAt(null, 1, 11);
            assert (root == null);

            root = LinkedList.insertAt(null, 4, 11);
            assert (root == null);

        }

        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.insertAt(root, 1, 11);

            assert (root.getNextOrNull().getData() == 11);

            root = LinkedList.insertAt(root, 3, 11);

            assert (root.getNextOrNull().getData() == 11);

        }

        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.append(root, 11);
            root = LinkedList.append(root, 12);
            root = LinkedList.append(root, 13);

            root = LinkedList.removeAt(root, 0);

            assert (root.getData() == 11);

            root = LinkedList.removeAt(root, 1);

            assert (root.getData() == 11);

            Node next = root.getNextOrNull();

            assert (next.getData() == 13);
        }

        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.append(root, 11);

            int index = LinkedList.getIndexOf(root, 10);

            assert (index == 0);

            index = LinkedList.getIndexOf(root, 11);

            assert (index == 1);
        }

        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.append(root, 11);

            Node node = LinkedList.getOrNull(root, 0);

            assert (node.getData() == 10);

            node = LinkedList.getOrNull(root, 1);

            assert (node.getData() == 11);
        }

        {
            Node root1 = LinkedList.append(null, 10);

            root1 = LinkedList.append(root1, 11);
            root1 = LinkedList.append(root1, 12);
            root1 = LinkedList.append(root1, 13);
            root1 = LinkedList.append(root1, 14);
            root1 = LinkedList.append(root1, 15);

            Node root2 = LinkedList.append(null, 16);

            root2 = LinkedList.append(root2, 17);
            root2 = LinkedList.append(root2, 18);

            Node newRoot = LinkedList.interleaveOrNull(root1, root2); // newRoot: 10, list: 10 -> 13 -> 11 -> 14 -> 12 -> 15

            assert (newRoot.getData() == 10);

            Node next = newRoot.getNextOrNull();

            assert (next.getData() == 16);

            next = next.getNextOrNull();

            assert (next.getData() == 11);

            next = next.getNextOrNull();

            assert (next.getData() == 17);

            next = next.getNextOrNull();

            assert (next.getData() == 12);

            next = next.getNextOrNull();

            assert (next.getData() == 18);

            next = next.getNextOrNull();
            assert (next.getData() == 13);
            next = next.getNextOrNull();
            assert (next.getData() == 14);
            next = next.getNextOrNull();
            assert (next.getData() == 15);

        }

        {
            Node root1 = LinkedList.append(null, 10);

            root1 = LinkedList.append(root1, 11);
            root1 = LinkedList.append(root1, 12);
            root1 = LinkedList.append(root1, 13);
            root1 = LinkedList.append(root1, 14);
            root1 = LinkedList.append(root1, 15);

            Node newRoot = LinkedList.interleaveOrNull(root1, null); // newRoot: 10, list: 10 -> 13 -> 11 -> 14 -> 12 -> 15
            assert (newRoot.getData() == 10);

            var next = newRoot.getNextOrNull();
            assert (next.getData() == 11);

            next = next.getNextOrNull();
            assert (next.getData() == 12);

            next = next.getNextOrNull();
            assert (next.getData() == 13);

            next = next.getNextOrNull();
            assert (next.getData() == 14);

            next = next.getNextOrNull();
            assert (next.getData() == 15);

        }

        {
            Node root = LinkedList.append(null, 10);

            root = LinkedList.append(root, 11);
            root = LinkedList.append(root, 12);
            root = LinkedList.append(root, 13);
            root = LinkedList.append(root, 14);

            root = LinkedList.reverse(root); // root: 14, list: 14 -> 13 -> 12 -> 11 -> 10

            assert (root.getData() == 14);

            Node next = root.getNextOrNull();

            assert (next.getData() == 13);

            next = next.getNextOrNull();

            assert (next.getData() == 12);

            next = next.getNextOrNull();

            assert (next.getData() == 11);

            next = next.getNextOrNull();

            assert (next.getData() == 10);
        }

        {
            Stack stack = new Stack();

            stack.push(20);
            stack.push(21); // stack: 21
            //        20

            int data = stack.pop();

            assert (data == 21);

            data = stack.pop();

            assert (data == 20);
        }

        {
            Stack stack = new Stack();

            stack.push(20); // stack: 20

            assert (stack.peek() == 20);

            stack.push(21); // stack: 21
            //        20

            assert (stack.peek() == 21);
        }

        {
            Stack stack = new Stack();

            stack.push(20);
            stack.push(21);

            assert (stack.getSize() == 2);
        }

        {
            Queue queue = new Queue();

            queue.enqueue(20);

            assert (queue.peek() == 20);

            queue.enqueue(21);

            assert (queue.peek() == 20);
        }

        {
            Queue queue = new Queue();

            queue.enqueue(20);
            queue.enqueue(21);


            int data = queue.dequeue();

            queue.enqueue(22);
            queue.enqueue(23);
            queue.enqueue(22);
            queue.enqueue(23);
            assert (data == 20);

            data = queue.dequeue();

            assert (data == 21);
        }

        {
            Queue queue = new Queue();

            queue.enqueue(20);
            queue.enqueue(21);

            assert (queue.getSize() == 2);
        }
    }
}
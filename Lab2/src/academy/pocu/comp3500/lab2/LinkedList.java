package academy.pocu.comp3500.lab2;

import academy.pocu.comp3500.lab2.datastructure.Node;

public class LinkedList {
    private LinkedList() {
    }

    public static Node append(final Node rootOrNull, final int data) {
        if (rootOrNull == null) {
            return new Node(data);
        }

        Node current = rootOrNull;
        Node prev = null;

        while (current != null) {
            prev = current;
            current = current.getNextOrNull();
        }

        prev.setNext(new Node(data));

        return rootOrNull;
    }

    public static Node prepend(final Node rootOrNull, final int data) {
        Node newNode = new Node(data);

        if (rootOrNull != null) {
            newNode.setNext(rootOrNull);
        }

        return newNode;
    }

    public static Node insertAt(final Node rootOrNull, final int index, final int data) {
        if (index < 0) {
            return null;
        }

        Node current = rootOrNull;
        Node prev = null;

        for (int i = 0; i < index; i++) {
            if (current == null) {
                return rootOrNull;
            }

            prev = current;
            current = current.getNextOrNull();
        }

        Node newNode = new Node(data);
        newNode.setNext(current);

        if (prev == null) {
            return newNode;
        }

        prev.setNext(newNode);

        return rootOrNull;
    }

    public static Node removeAt(final Node rootOrNull, final int index) {
        if (rootOrNull == null || index < 0) {
            return null;
        }

        Node current = rootOrNull;
        Node prev = null;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.getNextOrNull();

            if (current == null) {
                return rootOrNull;
            }
        }

        Node next = current.getNextOrNull();

        if (prev == null) {
            return next;
        }

        prev.setNext(next);

        return rootOrNull;
    }

    public static int getIndexOf(final Node rootOrNull, final int data) {
        if (rootOrNull == null) {
            return -1;
        }

        Node current = rootOrNull;
        int idx = 0;

        while (current != null) {
            if (current.getData() == data) {
                return idx;
            }
            current = current.getNextOrNull();
            idx++;
        }

        return -1;
    }

    public static Node getOrNull(final Node rootOrNull, final int index) {
        if (rootOrNull == null || index < 0) {
            return null;
        }

        Node current = rootOrNull;
        int idx = 0;

        while (current != null) {
            if (idx++ == index) {
                return current;
            }
            current = current.getNextOrNull();
        }

        return null;
    }

    public static Node reverse(final Node rootOrNull) {
        if (rootOrNull == null) {
            return null;
        }

        Node current = rootOrNull;
        Node prev = null;

        while (current != null) {
            Node next = current.getNextOrNull();

            current.setNext(prev);
            prev = current;
            current = next;
        }

        return prev;
    }

    public static Node interleaveOrNull(final Node root0OrNull, final Node root1OrNull) {
        if (root0OrNull == null && root1OrNull == null) {
            return null;
        } else if (root0OrNull == null) {
            return root1OrNull;
        } else if (root1OrNull == null) {
            return root0OrNull;
        }

        Node current0 = root0OrNull;
        Node current1 = root1OrNull;

        while (current0 != null && current1 != null) {
            Node temp0 = current0.getNextOrNull();
            Node temp1 = current1.getNextOrNull();

            if (current0.getNextOrNull() != null) {
                current1.setNext(current0.getNextOrNull());
            }
            current0.setNext(current1);

            current0 = temp0;
            current1 = temp1;
        }

        return root0OrNull;
    }
}

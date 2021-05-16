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

        while (true) {
            if (current.getNextOrNull() == null) {
                Node newNode = new Node(data);
                current.setNext(newNode);
                break;
            }
            current = current.getNextOrNull();
        }


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
        if (rootOrNull == null || index < 0) {
            return rootOrNull;
        }

        if (index == 0) {
            return LinkedList.prepend(rootOrNull, data);
        }

        Node current = rootOrNull.getNextOrNull();
        Node prevNode = rootOrNull;
        Node newNode = new Node(data);
        int currentIndex = 1;

        while (current != null) {
            if (currentIndex++ == index) {
                prevNode.setNext(newNode);
                newNode.setNext(current);
                return rootOrNull;
            }
            prevNode = current;
            current = current.getNextOrNull();
        }

        if (currentIndex == index) {
            prevNode.setNext(newNode);
        }

        return rootOrNull;
    }

    public static Node removeAt(final Node rootOrNull, final int index) {
        if (rootOrNull == null || index < 0) {
            return null;
        }

        Node current = rootOrNull;
        Node prev = null;
        int idx = 0;

        while (current != null) {
            if (idx++ == index) {
                if (prev == null) {
                    return current.getNextOrNull();
                }
                prev.setNext(current.getNextOrNull());
                break;
            }

            prev = current;
            current = current.getNextOrNull();
        }

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
        }

        Node current0 = root0OrNull;
        Node current1 = root1OrNull;
        Node temp0;
        Node temp1;

        Node result = current0;

        while (current0 != null && current1 != null) {
            temp0 = current0.getNextOrNull();
            temp1 = current1.getNextOrNull();

            if (current0.getNextOrNull() != null) {
                current1.setNext(current0.getNextOrNull());
            }
            current0.setNext(current1);

            current0 = temp0;
            current1 = temp1;
        }

        return result;
    }
}

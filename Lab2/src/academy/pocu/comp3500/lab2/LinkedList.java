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
            return null;
        }

        if (index == 0) {
            return LinkedList.prepend(rootOrNull, data);
        }

        Node current = rootOrNull;
        Node prevNode = null;
        Node newNode = new Node(data);
        int idx = 0;

        while (current != null) {
            if (idx++ == index) {
                prevNode.setNext(newNode);
                newNode.setNext(current);
                break;
            }
            prevNode = current;
            current = current.getNextOrNull();
        }

        return rootOrNull;
    }

    public static Node removeAt(final Node rootOrNull, final int index) {
        if (rootOrNull == null || index < 0) {
            return null;
        }

        if (index == 0) {
            return rootOrNull.getNextOrNull();
        }

        Node current = rootOrNull;
        Node prevNode = null;
        int idx = 0;
        while (current != null) {
            if (idx++ == index) {
                prevNode.setNext(current.getNextOrNull());
                break;
            }
            prevNode = current;
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
        Node newNode = null;

        while (current != null) {
            newNode = LinkedList.prepend(newNode, current.getData());
            current = current.getNextOrNull();
        }

        return newNode;
    }

    public static Node interleaveOrNull(final Node root0OrNull, final Node root1OrNull) {
        if (root0OrNull == null || root1OrNull == null) {
            return null;
        }

        Node current0 = root0OrNull;
        Node current1 = root1OrNull;
        Node newNode = null;

        while (current0 != null && current1 != null) {
            if (current0 != null) {
                newNode = LinkedList.append(newNode, current0.getData());
                current0 = current0.getNextOrNull();
            }
            if (current1 != null) {
                newNode = LinkedList.append(newNode, current1.getData());
                current1 = current1.getNextOrNull();
            }

        }

        return newNode;
    }
}

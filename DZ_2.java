package Algorithms_HW_2;

public class DZ_2 {
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        DZ_2 dz = new DZ_2();
        dz.run();
    }

    public void run() {
        int n = 1;
        while (n != 11) {
            add(n);
            n++;
        }
        printList(head);
        revert();
        System.out.println();
        printList(head);
    }

    public class Node {
        int value;
        Node next;
        Node previous;
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    private void printList(Node node) {
        while (node != null && node.next != null) {
            System.out.print(node.value + ", ");
            node = node.next;
        }
        if (node != null) {
            System.out.print(node.value);
        }
    }
}

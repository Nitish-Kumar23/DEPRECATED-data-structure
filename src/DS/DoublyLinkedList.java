package DS;

public class DoublyLinkedList {

    private static DoublyLinkedListNode head = null;
    private static DoublyLinkedListNode tail = null;
    private static int size = 0;

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        addNodeAtHead(2);
        addNodeAtHead(3);
        addNodeAtHead(8);
        printLinkedList();
        printLinkedListRev(getLastNode());
        addAtIndex(1, 17);
        addAtIndex(4, 19);
        addAtIndex(0, 11);
        printLinkedList();
    }

    private static void printLinkedListRev(DoublyLinkedListNode lastNode) {
        System.out.print("Print in reverse : ");
        DoublyLinkedListNode node = lastNode;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.prev;
        }
        System.out.println("END");
    }

    public static DoublyLinkedListNode getLastNode() {
        DoublyLinkedListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private static void printLinkedList() {
        DoublyLinkedListNode node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("END");
    }

    private static void addNodeAtHead(int value) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(value);
        if (head != null) {
            node.prev = head.prev;
            head.prev = node;
        }
        node.next = head;
        head = node;
        size++;
    }

    public static void addAtIndex(int index, int val) {

        if (index > size)
            return;

        if (index == 0) {
            addNodeAtHead(val);
            return;
        }

        if (index == size) {
            tail = getLastNode();
            DoublyLinkedListNode node = new DoublyLinkedListNode(val, tail, tail.next);
            tail.next = node;
            tail = node;
            return;
        }

        DoublyLinkedListNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        DoublyLinkedListNode node = new DoublyLinkedListNode(val, temp, temp.next);
        temp.next = node;
        node.next.prev = node;
        temp.setNext(node);
        size += 1;
    }
}

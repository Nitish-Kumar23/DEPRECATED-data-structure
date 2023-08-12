package ds.custom.implementation;

public class DoublyLinkedList {
    private static Node head = null;
    private static Node tail = null;
    private static int size = 0;

    public static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("data=").append(data);
            sb.append(", prev=").append(prev);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }


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

    private static void printLinkedListRev(Node lastNode) {
        System.out.print("Print in reverse : ");
        Node node = lastNode;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.prev;
        }
        System.out.println("END");
    }

    public static Node getLastNode() {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private static void printLinkedList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("END");
    }

    private static void addNodeAtHead(int value) {
        Node node = new Node(value);
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
            Node node = new Node(val, tail, tail.next);
            tail.next = node;
            tail = node;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        Node node = new Node(val, temp, temp.next);
        temp.next = node;
        node.next.prev = node;
        temp.setNext(node);
        size += 1;
    }
    
    

}

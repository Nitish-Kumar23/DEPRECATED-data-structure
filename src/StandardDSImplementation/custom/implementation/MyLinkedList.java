package StandardDSImplementation.custom.implementation;

public class MyLinkedList {

    private static LinkedListNode head;
    private int size;

    public class LinkedListNode {
        private int value;
        private LinkedListNode next;

        public LinkedListNode() {
        }

        public LinkedListNode(int value, LinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public LinkedListNode(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public LinkedListNode getNext() {
            return next;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.size = 0;
    }

    public static LinkedListNode getHead() {
        return head;
    }

    public static void setHead(LinkedListNode head) {
        MyLinkedList.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        /**
         * 
         * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
         * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.deleteAtIndex(1);
        printLinkedList();
         **/
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        printLinkedList();
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
        printLinkedList();
    }

    public static void printLinkedList() {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + "->");
            temp = temp.getNext();
        }
        System.out.println("END");
    }

    public void deleteAtIndex(int index) {
        
        if(index>=size){
            return;
        }
        if(index==0){
            head = head.getNext();
            size--;
            return;
        }
        LinkedListNode temp = head;
        for (int i=0;i<index-1;i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        size--;
    }

    public int get(int index) {
        int count = 0;
        LinkedListNode temp = head;
        while (temp != null) {
            if (index == count) {
                return temp.getValue();
            }
            count++;
            temp = temp.getNext();
        }
        return -1;
    }

    public void addAtHead(int val) {
        LinkedListNode node = new LinkedListNode(val);
        node.setNext(head);
        head = node;
        size += 1;
    }

    public void addAtTail(int val) {
        LinkedListNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(new LinkedListNode(val));
        size++;
    }

    public void addAtIndex(int index, int val) {

        if (index > size)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        LinkedListNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        LinkedListNode node = new LinkedListNode(val, temp.getNext());
        temp.setNext(node);
        size+=1;
    }

}
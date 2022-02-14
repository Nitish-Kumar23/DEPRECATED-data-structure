package DS;

import java.util.LinkedList;

public class DoublyLinkedList {
    
    private static DoublyLinkedListNode head = null;
    private static DoublyLinkedListNode tail = null;
    private static int size = 0;
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addNodeAtHead(2);
        list.addNodeAtHead(3);
        list.addNodeAtHead(8);
        printLinkedList();
        printLinkedListRev(getLastNode());
    }

    private static void printLinkedListRev(DoublyLinkedListNode lastNode) {
        System.out.print("Print in reverse : ");
        DoublyLinkedListNode node = lastNode;
        while (node!=null){
            System.out.print(node.data+"->");
            node = node.prev;
        }
        System.out.println("END");
    }

    public static DoublyLinkedListNode getLastNode(){
        DoublyLinkedListNode node = head;
        while (node.next!=null){
            node = node.next;
        }
        return node;
    }

    private static void printLinkedList() {
        DoublyLinkedListNode node = head;
        while (node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.println("END");
    }

    private void addNodeAtHead(int value) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(value);
        if(head!=null) {
            node.prev = head.prev;
            head.prev =node;
        }
        node.next = head;
        head = node;
        size++;
    }
}

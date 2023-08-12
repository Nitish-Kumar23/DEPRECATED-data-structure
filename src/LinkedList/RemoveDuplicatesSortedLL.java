package LinkedList;

import StandardDSImplementation.custom.implementation.MyLinkedList;

public class RemoveDuplicatesSortedLL {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtTail(5);
        list.addAtTail(5);
        list.addAtTail(5);
        list.addAtTail(17);
        list.addAtTail(39);
        list.addAtTail(39);
        MyLinkedList.printLinkedList();
        deleteDuplicates(MyLinkedList.getHead());
        MyLinkedList.printLinkedList();

    }

    public static MyLinkedList.LinkedListNode deleteDuplicates(MyLinkedList.LinkedListNode head) {
        MyLinkedList.LinkedListNode node = head;
        while(node!=null && node.getNext()!=null){
            if(node.getValue()==node.getNext().getValue()){
                node.setNext(node.getNext().getNext());
            }else{
                node = node.getNext();
            }
        }
        return head;
    }
}

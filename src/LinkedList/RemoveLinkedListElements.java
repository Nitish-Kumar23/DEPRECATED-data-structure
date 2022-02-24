package LinkedList;

import DS.LLNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        LLNode node1 = new LLNode(1);
        LLNode node2 = new LLNode(2);
        LLNode node3 = new LLNode(6);
        LLNode node4 = new LLNode(3);
        LLNode node5 = new LLNode(4);
        LLNode node6 = new LLNode(5);
        LLNode node7 = new LLNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node1.printLinkedList();
        removeElements(node1,6).printLinkedList();
    }

    public static LLNode removeElements(LLNode head, int val) {
        if(head==null){
            return null;
        }
        LLNode headV = removeElements(head.next,val);
        if(head.value==val){
            return headV;
        }
        head.next=headV;
        return head;

    }
}

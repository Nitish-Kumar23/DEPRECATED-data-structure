package LinkedList;

import DS.ListNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node1.printLinkedList();
        removeElements(node1,6).printLinkedList();
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode headV = removeElements(head.next,val);
        if(head.val ==val){
            return headV;
        }
        head.next=headV;
        return head;

    }
}

package LinkedList;

import ds.custom.implementation.ListNode;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        System.out.println(removeNthFromEnd(head,1));
        head.printLinkedList();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length=0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        //edge case if length of list is equal to n then first node need to be deleted
        if(length==n){
            head = head.next;
            return head;
        }
        int count = length-(n-1);
        int currentPos = 1;
        ListNode node = head;
        while(node!=null){
            if(count==currentPos+1){
                node.next = node.next.next;
                return head;
            }
            node = node.next;
            currentPos++;
        }
        return head;
    }
}

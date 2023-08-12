package LinkedList;

import ds.custom.implementation.ListNode;

public class MiddleLinkedList {
    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        MiddleLinkedList list = new MiddleLinkedList();
        System.out.println(list.middleNode(head).val);
        System.out.println(middleNodeV1(head).val);
    }

    /**
     * Two pointer approach -  if we keep two pointers slow and fast(increase by 2)
     * the slow will be at mid when fast reaches end of the list
     * 
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Get middle of linked list
     * length of LL and then iterate till mid element and return
     * time complexity - O(n)
     * 
     * @param head
     * @return
     */
    private static ListNode middleNodeV1(ListNode head){
        ListNode temp = head;
        int length=0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        //mid element will be len/2 + len%2 (because in case there are two mids then we have to return 2nd mid)
        int mid = (length-1)/2 + (length-1)%2;
        ListNode node = head;
        int count=0;
        while(node!=null){
            if(count==mid){
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }
}

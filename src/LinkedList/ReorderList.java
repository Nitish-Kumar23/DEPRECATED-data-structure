package LinkedList;

import DS.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        ListNode node9 = new ListNode(9);
        ListNode node8 = new ListNode(8,node9);
        ListNode node7 = new ListNode(7,node8);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        head.printLinkedList();
        reorderList(head);
        head.printLinkedList();
    }

    /**
     * https://leetcode.com/problems/reorder-list/
     * Time complexity - O(n)
     * find the mid of LL, reverse the second half and then use two pointers to rearrange LL
     * @param head
     */
    private static void reorderList(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode headReverse = reverseLL(middle);
        ListNode tempHead = head;
        ListNode indexNode = null;
        while (tempHead!=null && headReverse!=null){
            if(indexNode==null){
                ListNode tempFirst = tempHead.next;
                indexNode = tempHead;
                indexNode.next = headReverse;
                indexNode = indexNode.next;
                tempHead = tempFirst;
                headReverse = headReverse.next;
                continue;
            }
            ListNode tempFirst = tempHead.next;
            ListNode tempSecond = headReverse.next;
            indexNode.next = tempHead;
            indexNode.next.next = headReverse;
            indexNode = indexNode.next.next;
            tempHead = tempFirst;
            headReverse = tempSecond;
        }
        indexNode.next=null;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseLL(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current!=null){
            ListNode temp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = temp;
        }
        return prev;
    }
}

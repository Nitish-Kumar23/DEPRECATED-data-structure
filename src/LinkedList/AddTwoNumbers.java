package LinkedList;

import DS.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(null);
        addTwoNUmber(node1, node5).printLinkedList();
    }

    private static ListNode addTwoNUmber(ListNode node1, ListNode node5) {
        ListNode head1 = node1;
        ListNode head2 = node5;
        ListNode result = null;
        ListNode temp = null;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.getVal() + head2.getVal() + carry;
            int nodeValue = sum % 10;
            if (result == null) {
                result = new ListNode(nodeValue, null);
                head1 = head1.next;
                head2 = head2.next;
                carry = sum / 10;
                temp = result;
                continue;
            }
            temp.next = new ListNode(nodeValue, null);
            temp = temp.next;
            carry = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 == null) {
            if (carry != 0) {
                temp.next = new ListNode(carry, null);
            }
            return result;
        }
        while (head1 != null) {
            int sum = head1.val + carry;
            int nodeValue = sum % 10;
            temp.next = new ListNode(nodeValue, null);
            temp = temp.next;
            head1 = head1.next;
            carry = sum / 10;
        }
        if (head1 == null && carry != 0) {
            temp.next = new ListNode(carry, null);
        }
        while (head2 != null) {
            int sum = head2.val + carry;
            int nodeValue = sum % 10;
            temp.next = new ListNode(nodeValue, null);
            temp = temp.next;
            head2 = head2.next;
            carry = sum / 10;
        }
        if (head2 == null && carry != 0) {
            temp.next = new ListNode(carry, null);
        }
        return result;
    }
}

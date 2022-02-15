package LinkedList;

import DS.LLNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        LLNode node1 = new LLNode(2);
        LLNode node2 = new LLNode(4);
        LLNode node3 = new LLNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);
        LLNode node5 = new LLNode(5);
        LLNode node6 = new LLNode(6);
        LLNode node7 = new LLNode(4);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(null);
        addTwoNUmber(node1, node5).printLinkedList();
    }

    private static LLNode addTwoNUmber(LLNode node1, LLNode node5) {
        LLNode head1 = node1;
        LLNode head2 = node5;
        LLNode result = null;
        LLNode temp = null;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.getValue() + head2.getValue() + carry;
            int nodeValue = sum % 10;
            if (result == null) {
                result = new LLNode(nodeValue, null);
                head1 = head1.next;
                head2 = head2.next;
                carry = sum / 10;
                temp = result;
                continue;
            }
            temp.next = new LLNode(nodeValue, null);
            temp = temp.next;
            carry = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 == null) {
            if (carry != 0) {
                temp.next = new LLNode(carry, null);
            }
            return result;
        }
        while (head1 != null) {
            int sum = head1.value + carry;
            int nodeValue = sum % 10;
            temp.next = new LLNode(nodeValue, null);
            temp = temp.next;
            head1 = head1.next;
            carry = sum / 10;
        }
        if (head1 == null && carry != 0) {
            temp.next = new LLNode(carry, null);
        }
        while (head2 != null) {
            int sum = head2.value + carry;
            int nodeValue = sum % 10;
            temp.next = new LLNode(nodeValue, null);
            temp = temp.next;
            head2 = head2.next;
            carry = sum / 10;
        }
        if (head2 == null && carry != 0) {
            temp.next = new LLNode(carry, null);
        }
        return result;
    }
}

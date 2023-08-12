package LinkedList;

import ds.custom.implementation.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeV1(head));
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        ListNode temp = head;
        while (temp!=null){
            if(temp.val != stack.pop().val){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    private static boolean isPalindromeV1(ListNode head) {
        ListNode middle = new MiddleLinkedList().middleNode(head);
        ListNode headSecond = new ReverseLinkedList().reverseLLV2(middle);
        ListNode rereverseHead = headSecond; 
        while (head!=null && headSecond!=null){
            if(head.val!=headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        new ReverseLinkedList().reverseLLV2(rereverseHead);
        if(head==null || headSecond==null){
            return true;
        }
        return false;
    }
}

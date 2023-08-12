package LinkedList;

import StandardDSImplementation.custom.implementation.ListNode;
import StandardDSImplementation.custom.implementation.MyLinkedList;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        MyLinkedList.printLinkedList();
//        printLL(reverseLL(MyLinkedList.getHead()));
        printLL(new ReverseLinkedList().reverseLLV2(MyLinkedList.getHead()));
        
    }

    private static void printLL(MyLinkedList.LinkedListNode head) {
        MyLinkedList.LinkedListNode node = head;
        while (node!=null){
            System.out.print(node.getValue()+"->");
            node = node.getNext();
        }
        System.out.println("END");
    }

    private static MyLinkedList.LinkedListNode reverseLL(MyLinkedList.LinkedListNode head) {
        Stack<MyLinkedList.LinkedListNode> stack = new Stack<>();
        MyLinkedList.LinkedListNode node = head;
        while (node!=null){
            stack.push(node);
            node = node.getNext();
        }
        MyLinkedList.LinkedListNode reverseLLHead = null;
        MyLinkedList.LinkedListNode cNode = null;
        while (!stack.isEmpty()){
            if(reverseLLHead==null){
                reverseLLHead = stack.pop();
                cNode = reverseLLHead;
                continue;
            }
            cNode.setNext(stack.pop());
            cNode = cNode.getNext();
        }
        cNode.setNext(null);
        return reverseLLHead;
    }

    public MyLinkedList.LinkedListNode reverseLLV2(MyLinkedList.LinkedListNode head) {
        MyLinkedList.LinkedListNode current = head;
        MyLinkedList.LinkedListNode prev = null;
        while (current!=null){
            MyLinkedList.LinkedListNode temp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = temp;
        }
        return prev;
    }

    public ListNode reverseLLV2(ListNode head) {
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

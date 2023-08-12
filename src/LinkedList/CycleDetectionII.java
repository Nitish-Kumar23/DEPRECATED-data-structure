package LinkedList;

import StandardDSImplementation.custom.implementation.ListNode;

public class CycleDetectionII {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        ListNode result = detectCycle(node1);
        System.out.println(result.val);
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer!=null && fastPointer.getNext()!=null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
            if(slowPointer==fastPointer) {
                int length = CycleDetection.lengthCycle(slowPointer);
                ListNode firstNode = head;
                ListNode secondNode = head;
                while (length>0){
                    secondNode=secondNode.next;
                    length--;
                }
                while (firstNode!=secondNode){
                    firstNode = firstNode.next;
                    secondNode = secondNode.next;
                }
                return secondNode;
            }
        }
        return null;
    }
}

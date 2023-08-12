package LinkedList;

import ds.custom.implementation.ListNode;

import java.util.HashMap;

public class CycleDetection {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        System.out.println(isCyclic(node1));
        System.out.println(isCyclicV2(node1));
    }

    private static boolean isCyclic(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap();
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, temp.getVal());
            temp = temp.getNext();
        }
        return false;
        
    }

    private static boolean isCyclicV2(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer!=null && fastPointer.getNext()!=null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
            if(slowPointer==fastPointer) {
                System.out.println(lengthCycle(slowPointer));
                return true;
            }
        }
        return false;

    }

    public static int lengthCycle(ListNode slowPointer) {
        ListNode node = slowPointer;
        int count =1;
        while (true){
            slowPointer = slowPointer.next;
            if(slowPointer==node){
                return count;
            }
            count++;
        }
    }
}

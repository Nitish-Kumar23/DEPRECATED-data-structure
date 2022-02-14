package LinkedList;

import DS.LLNode;

import java.util.HashMap;

public class CycleDetection {
    public static void main(String[] args) {
        LLNode node1 = new LLNode(3);
        LLNode node2 = new LLNode(2);
        LLNode node3 = new LLNode(3);
        LLNode node4 = new LLNode(-4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        System.out.println(isCyclic(node1));
        System.out.println(isCyclicV2(node1));
    }

    private static boolean isCyclic(LLNode head) {
        HashMap<LLNode, Integer> map = new HashMap();
        LLNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, temp.getValue());
            temp = temp.getNext();
        }
        return false;
        
    }

    private static boolean isCyclicV2(LLNode head) {
        LLNode slowPointer = head;
        LLNode fastPointer = head;
        while (fastPointer!=null && fastPointer.getNext()!=null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
            if(slowPointer==fastPointer)
                return true;
        }
        return false;

    }
}

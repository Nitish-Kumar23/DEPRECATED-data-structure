package LinkedList;

import ds.custom.implementation.ListNode;

public class MergeTwoSortedLL {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(2,node3);
        ListNode list1 = new ListNode(1,node2);
        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(3,node5);
        ListNode list2 = new ListNode(1,node4);
        ListNode head = mergeTwoLists(list1,list2);
        head.printLinkedList();
    }
    
    public static ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode ans = new ListNode();
        ListNode tail = ans;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1!=null?list1 : list2;
        return ans.next;
    }
}

package StandardDSImplementation.custom.implementation;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    public ListNode(int value) {
        this.val = value;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    
    public void printLinkedList(){
        ListNode temp = this;
        while (temp != null) {
            System.out.print(temp.getVal() + "->");
            temp = temp.getNext();
        }
        System.out.println("END");
    }
    
}

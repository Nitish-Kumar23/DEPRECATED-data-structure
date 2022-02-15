package DS;

public class LLNode {
    public int value;
    public LLNode next;

    public LLNode() {
    }

    public LLNode(int value, LLNode next) {
        this.value = value;
        this.next = next;
    }

    public LLNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
    
    public void printLinkedList(){
        LLNode temp = this;
        while (temp != null) {
            System.out.print(temp.getValue() + "->");
            temp = temp.getNext();
        }
        System.out.println("END");
    }
    
}

package DS;

public class LLNode {
    private int value;
    private LLNode next;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedListNode{");
        sb.append("value=").append(value);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}

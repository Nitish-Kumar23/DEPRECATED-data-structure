package DS;

public class CircularLinkedList {
    public LLNode head;
    public LLNode tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public CircularLinkedList(LLNode head, LLNode tail) {
        this.head = head;
        this.tail = tail;
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertNode(1);
        list.insertNode(17);
        list.insertNode(18);
        list.insertNode(3);
        list.deleteNode(list.getNode(18));
        list.printLinkedList();
    }
    
    public LLNode getNode(int value){
        LLNode node = head;
        if(head!=null){
            do{
                if(node.getValue()==value)
                    return node;
                node = node.getNext();
            }while (node!=head);
        }
        return null;
    }

    private void printLinkedList() {
        LLNode node = head;
        while (node!=tail){
            System.out.print(node.getValue()+"->");
            node=node.getNext();
        }
        System.out.println(node.getValue()+"->HEAD");

    }

    private void printLinkedListV1() {
        LLNode node = head;
        if (head != null) {
            do {
                System.out.print(node.getValue() + "->");
                node = node.getNext();
            } while (node != head);
            System.out.println("HEAD");
        }
    }

    public  void insertNode(int value){
        LLNode node = new LLNode(value);
        if(head==null){
            head = node;
            tail = node;
            return;
        }
        tail.setNext(node);
        node.setNext(head);
        tail = node;
    }
    
    public void deleteNode(LLNode deletionNode){
        LLNode node = head;
        if(head!=null){
            do {
                if(node.getNext()==deletionNode){
                    node.setNext(node.getNext().getNext());
                    return;
                }
                node = node.getNext();
            }while (node!=head);
        }
    }
}

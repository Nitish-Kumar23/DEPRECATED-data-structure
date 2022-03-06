package DS;

public class CircularLinkedList {
    public ListNode head;
    public ListNode tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public CircularLinkedList(ListNode head, ListNode tail) {
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
    
    public ListNode getNode(int value){
        ListNode node = head;
        if(head!=null){
            do{
                if(node.getVal()==value)
                    return node;
                node = node.getNext();
            }while (node!=head);
        }
        return null;
    }

    private void printLinkedList() {
        ListNode node = head;
        while (node!=tail){
            System.out.print(node.getVal()+"->");
            node=node.getNext();
        }
        System.out.println(node.getVal()+"->HEAD");

    }

    private void printLinkedListV1() {
        ListNode node = head;
        if (head != null) {
            do {
                System.out.print(node.getVal() + "->");
                node = node.getNext();
            } while (node != head);
            System.out.println("HEAD");
        }
    }

    public  void insertNode(int value){
        ListNode node = new ListNode(value);
        if(head==null){
            head = node;
            tail = node;
            return;
        }
        tail.setNext(node);
        node.setNext(head);
        tail = node;
    }
    
    public void deleteNode(ListNode deletionNode){
        ListNode node = head;
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

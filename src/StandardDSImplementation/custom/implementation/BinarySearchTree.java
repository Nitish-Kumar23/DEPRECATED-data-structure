package StandardDSImplementation.custom.implementation;

public class BinarySearchTree<T extends Comparable<T>> {
    
    private Node root = null;
    public class Node{
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    
//    public Node add(Node root, T element){
//        
//        if(root==null) {
//            root = new Node(element);
//        }
//        if(element.compareTo(root.getLeft().getData())<0){
//            Node node = add(root.getLeft(),element);
//            node.setLeft(node);
//        }
//    }
//
//    @Override
//    public int compareTo(T o) {
//        return 0;
//    }
    
}

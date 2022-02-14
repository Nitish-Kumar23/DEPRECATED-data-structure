package Trees;

import DS.BinaryTree;

public class MaxDepth {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        BinaryTree node1 = new BinaryTree(2);
        BinaryTree node2 = new BinaryTree(3);
        BinaryTree node3 = new BinaryTree(4);
        BinaryTree node4 = new BinaryTree(5);
        BinaryTree node5 = new BinaryTree(6);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(BinaryTree root) {
        if(root==null){
            return 0;
        }
        int leftHeight = maxDepth(root.getLeft());
        int rightHegith = maxDepth(root.getRight());
        return 1+Math.max(leftHeight,rightHegith);
    }
}

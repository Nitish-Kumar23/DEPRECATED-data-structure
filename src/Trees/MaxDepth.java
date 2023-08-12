package Trees;

import StandardDSImplementation.custom.implementation.BinaryTreeNode;

public class MaxDepth {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(BinaryTreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight = maxDepth(root.getLeft());
        int rightHegith = maxDepth(root.getRight());
        return 1+Math.max(leftHeight,rightHegith);
    }
}

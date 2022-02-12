package Trees;

import DS.BinaryTree;

public class CountTreeNodes {
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
        System.out.println(getTreeNodes(root));
    }

    private static int getTreeNodes(BinaryTree root) {
        if(root==null){
            return 0;
        }
        int leftNodeCount = getTreeNodes(root.getLeft());
        int rightNodeCount = getTreeNodes(root.getRight());
        return 1+leftNodeCount+rightNodeCount;
    }
}

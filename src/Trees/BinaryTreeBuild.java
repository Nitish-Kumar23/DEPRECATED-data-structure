package Trees;

import DS.BinaryTreeNode;

import java.util.Scanner;

public class BinaryTreeBuild {

    public static void main(String[] args) {
        // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        System.out.println("Enter the data for root node ");
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        BinaryTreeNode root = buildBinaryTree(data,scanner);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static BinaryTreeNode buildBinaryTree(int data,Scanner scanner) {
        if (data == -1) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(data);
        System.out.println("Enter the data for inserting in left node of " + data);
        int leftVal = scanner.nextInt();
        BinaryTreeNode left = buildBinaryTree(leftVal,scanner);
        System.out.println("Enter the data for inserting in right node " + data);
        int rightVal = scanner.nextInt();
        BinaryTreeNode right = buildBinaryTree(rightVal,scanner);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }
}

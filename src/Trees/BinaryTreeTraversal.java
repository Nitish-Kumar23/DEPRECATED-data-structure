package Trees;

import StandardDSImplementation.custom.implementation.BinaryTreeNode;

import java.util.Scanner;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Tree input -> 17 11 4 -1 -1 -1 93 -1 -1 9 -1 8 5 -1 -1 10 -1 -1
        BinaryTreeNode root = BinaryTreeBuild.buildBinaryTree(25,scanner);
        System.out.print("Inorder traversal : ");
        inorder(root);
        System.out.println();
        System.out.print("Pre-order traversal : ");
        preOrder(root);
        System.out.println();
        System.out.print("Post order traversal : ");
        postOrder(root);
    }

    private static void postOrder(BinaryTreeNode root) {
        if(root==null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getVal() + " ");
    }

    private static void preOrder(BinaryTreeNode root) {
        if(root==null)
            return;
        System.out.print(root.getVal() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static void inorder(BinaryTreeNode root) {
        if(root==null)
            return;
        inorder(root.getLeft());
        System.out.print(root.getVal() + " ");
        inorder(root.getRight());
    }
}

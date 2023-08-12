package Trees;

import StandardDSImplementation.custom.implementation.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeFromLevelOrder {

    public static void main(String[] args) {
        // 1 3 5 7 11 17 -1 -1 -1 -1 -1 -1 -1 
        BinaryTreeNode root = new BinaryTreeNode();
        root = buildBinaryTreeFromLevelOrderTraversal(root);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    private static BinaryTreeNode buildBinaryTreeFromLevelOrderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        System.out.println("Enter data for root : ");
        Scanner scanner = new Scanner(System.in);
        root = new BinaryTreeNode(scanner.nextInt());
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            System.out.println("Enter data for left of  : " + node.getVal());
            int left = scanner.nextInt();
            if(left!=-1){
                BinaryTreeNode leftNode = new BinaryTreeNode(left);
                queue.add(leftNode);
                node.setLeft(leftNode);
            }
            System.out.println("Enter data for right of  : " + node.getVal());
            int right = scanner.nextInt();
            if(right!=-1){
                BinaryTreeNode rightNode = new BinaryTreeNode(right);
                queue.add(rightNode);
                node.setRight(rightNode);
            }
        }
        return root;
    }
}

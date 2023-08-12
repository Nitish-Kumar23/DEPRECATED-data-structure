package Trees;

import StandardDSImplementation.custom.implementation.BinaryTreeNode;

import java.util.Scanner;

public class LeafNodes {

    public static void main(String[] args) {
        // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter root node : ");
        BinaryTreeNode root = BinaryTreeBuild.buildBinaryTree(scanner.nextInt(),scanner);
        System.out.println("-----------------------");
        System.out.println("Total left nodes = " + countLeafNodes(root));
        System.out.println("-----------------------");

    }

    private static int countLeafNodes(BinaryTreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.getLeft()==null && root.getRight()==null){
            return 1;
        }
        int left =  countLeafNodes(root.getLeft());
        int right = countLeafNodes(root.getRight());
        return left+right;
    }
}

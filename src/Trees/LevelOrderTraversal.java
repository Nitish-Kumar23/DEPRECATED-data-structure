package Trees;

import StandardDSImplementation.custom.implementation.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeNode root = BinaryTreeBuild.buildBinaryTree(25,scanner);
        levelOrderTraversal(root);
    }

    /**
     * QUEUE based approach
     * 
     * @param root
     */
    public static void levelOrderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<>();
        binaryTreeNodeQueue.add(root);
        binaryTreeNodeQueue.add(null);
        System.out.println(root.getVal());

        while (!binaryTreeNodeQueue.isEmpty()) {
            BinaryTreeNode temp = binaryTreeNodeQueue.poll();
            if (temp == null) {
                if (binaryTreeNodeQueue.isEmpty()) {
                    return;
                }
                System.out.println();
                binaryTreeNodeQueue.add(null);
                temp = binaryTreeNodeQueue.poll();
            }
            if (temp.getLeft() != null) {
                System.out.print(temp.getLeft().getVal()+" ");
                binaryTreeNodeQueue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                System.out.print(temp.getRight().getVal()+" ");
                binaryTreeNodeQueue.add(temp.getRight());
            }
        }
    }
}

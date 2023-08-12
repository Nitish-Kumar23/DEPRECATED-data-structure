package StandardDSImplementation.custom.implementation;

public class BinaryTreeNode {
    private int val;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("val=").append(val);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}

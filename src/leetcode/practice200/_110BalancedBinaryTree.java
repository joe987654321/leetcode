package leetcode.practice200;

import java.util.Stack;

import leetcode.treenode.TreeNode;

public class _110BalancedBinaryTree {
    public static void main(String[] args) {
        _110BalancedBinaryTree balancedBinaryTree = new _110BalancedBinaryTree();
        TreeNode t = TreeNode.createTree(new Integer[] {1,2,2,3,3,3,null,4,4,4,4,4,4,null,null,5,5});
        boolean balanced = balancedBinaryTree.isBalanced(t);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return levelCount(root, 0) >= 0;
    }

    private int levelCount(TreeNode root, int nowLevel) {
        if (root == null) return nowLevel;
        int levelLeft = levelCount(root.left, nowLevel+1);
        if (levelLeft == -1) return -1;
        int levelRight = levelCount(root.right, nowLevel+1);
        if (levelRight == -1) return -1;
        return Math.abs(levelLeft-levelRight) <= 1 ?
            Math.max(levelLeft, levelRight) : -1;
    }
}

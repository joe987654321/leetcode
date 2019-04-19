package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _112PathSum {
    public static void main(String[] args) {
        _112PathSum pathSum = new _112PathSum();
        TreeNode tree = TreeNode
                .createTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1 });
        boolean b = pathSum.hasPathSum(tree, 22);
        System.out.println(b);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}

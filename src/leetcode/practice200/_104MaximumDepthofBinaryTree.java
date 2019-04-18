package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _104MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        _104MaximumDepthofBinaryTree maximumDepthofBinaryTree = new _104MaximumDepthofBinaryTree();
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        int i = maximumDepthofBinaryTree.maxDepth(tree);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}

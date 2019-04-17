package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _101SymmetricTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3, 5});
        _101SymmetricTree symmetricTree = new _101SymmetricTree();
        boolean b = symmetricTree.isSymmetric(tree);
        System.out.println(b);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }
}

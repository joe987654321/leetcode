package leetcode.joe;

import leetcode.treenode.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.left = new TreeNode(2);

        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        System.out.println(symmetricTree.isSymmetric(root));

    }

    public boolean isSymmetric(TreeNode root) {
        return _isSymmetric(root, root);

    }

    public boolean _isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null || left.val != right.val) {
            return false;
        } else {
            return _isSymmetric(left.left, right.right) && _isSymmetric(left.right, right.left);
        }
    }
}

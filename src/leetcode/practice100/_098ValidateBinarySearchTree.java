package leetcode.practice100;

import leetcode.treenode.TreeNode;

public class _098ValidateBinarySearchTree {
    public static void main(String[] args) {
        _098ValidateBinarySearchTree validateBinarySearchTree = new _098ValidateBinarySearchTree();
        TreeNode tree = TreeNode.createTree(new Integer[] { 5, 1, 4, null, null, 3, 6 });
        TreeNode.printTree(tree);
        boolean validBST = validateBinarySearchTree.isValidBST(tree);
        System.out.println(validBST);

        tree = TreeNode.createTree(new Integer[] { 5, 1, 7, null, null, 6, 8 });
        TreeNode.printTree(tree);
        validBST = validateBinarySearchTree.isValidBST(tree);
        System.out.println(validBST);

        tree = TreeNode.createTree(new Integer[] { 1,1 });
        TreeNode.printTree(tree);
        validBST = validateBinarySearchTree.isValidBST(tree);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    private boolean _isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        if (!_isValidBST(root.left, min, root.val)) {
            return false;
        }
        return _isValidBST(root.right, root.val, max);
    }
}

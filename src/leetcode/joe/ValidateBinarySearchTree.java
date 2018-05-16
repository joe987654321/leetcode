package leetcode.joe;

import leetcode.treenode.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(3);
        r1.left = r2;
        r1.right = r3;
        boolean validBST = validateBinarySearchTree.isValidBST(r1);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    private boolean _isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max ) {
            return false;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (root.right != null && root.right.val < root.val) {
            return false;
        }
        if (root.left != null && root.left.val > root.val) {
            return false;
        }
        return _isValidBST(root.left, min, root.val) && _isValidBST(root.right, root.val, max);
    }



}


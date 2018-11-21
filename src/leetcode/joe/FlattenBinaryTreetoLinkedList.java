package leetcode.joe;

import leetcode.treenode.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        FlattenBinaryTreetoLinkedList flattenBinaryTreetoLinkedList = new FlattenBinaryTreetoLinkedList();
        TreeNode.printTree(root);
        flattenBinaryTreetoLinkedList.flatten(root);
        TreeNode.printTree(root);
    }

    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                current = current.right;
            } else if (current.right == null) {
                current.right = current.left;
                current.left = null;
                current = current.right;
            } else {
                TreeNode nextRightEmpty = current.left;
                while (nextRightEmpty.right != null) {
                    nextRightEmpty = nextRightEmpty.right;
                }
                nextRightEmpty.right = current.right;
                current.right = current.left;
                current.left = null;
                current = current.right;
            }
        }
    }
}

package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _114FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        _114FlattenBinaryTreetoLinkedList flattenBinaryTreetoLinkedList = new _114FlattenBinaryTreetoLinkedList();
        TreeNode root = TreeNode.createTree(new Integer[] {1,2,5,3,4,null,6});
        TreeNode.printTree(root);
        flattenBinaryTreetoLinkedList.flatten(root);
        TreeNode.printTree(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode now = root;
        while (now != null) {
            if (now.left != null) {
                if (now.right == null) {
                    now.right = now.left;
                    now.left = null;
                } else {
                    TreeNode nextPos = now.left;
                    while (nextPos.right != null) nextPos = nextPos.right;
                    nextPos.right = now.right;
                    now.right = now.left;
                    now.left = null;
                }
            }
            now = now.right;
        }
    }
}

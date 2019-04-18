package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _105ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        _105ConstructBinaryTreefromPreorderandInorderTraversal constructBinaryTreefromPreorderandInorderTraversal = new _105ConstructBinaryTreefromPreorderandInorderTraversal();
        int [] input1 = new int[] {3,9,20,15,7};
        int [] input2 = new int[] {9,3,15,20,7};
        TreeNode treeNode = constructBinaryTreefromPreorderandInorderTraversal.buildTree(input1, input2);
        TreeNode.printTree(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) return null;
        return _buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode _buildTree(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if (s1 == e1) return null;
        int rootVal = preorder[s1];
        TreeNode root = new TreeNode(rootVal);
        int i;
        for (i = s2; i < e2; i++) {
            if (inorder[i] == rootVal) break;
        }
        root.left = _buildTree(preorder, inorder, s1+1, s1+1+i-s2, s2, i);
        root.right = _buildTree(preorder, inorder, s1+1+i-s2, e1, i+1, e2);
        return root;
    }
}

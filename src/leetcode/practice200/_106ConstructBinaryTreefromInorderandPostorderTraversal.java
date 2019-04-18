package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _106ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args) {
        _106ConstructBinaryTreefromInorderandPostorderTraversal c = new _106ConstructBinaryTreefromInorderandPostorderTraversal();
        int [] input1 = new int[] {9,3,15,20,7};
        int [] input2 = new int[] {9,15,7,20,3};
        TreeNode treeNode = c.buildTree(input1, input2);
        TreeNode.printTree(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) return null;
        return _buildTree(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode _buildTree(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        if (s1 == e1) return null;
        int rootVal = postorder[e2-1];
        TreeNode root = new TreeNode(rootVal);
        int i;
        for (i = s1; i < e1; i++) {
            if (inorder[i] == rootVal) break;
        }
        root.right = _buildTree(inorder, postorder, i+1, e1, e2-e1+i, e2-1);
        root.left = _buildTree(inorder, postorder, s1, i, s2, e2-e1+i);
        return root;
    }


}

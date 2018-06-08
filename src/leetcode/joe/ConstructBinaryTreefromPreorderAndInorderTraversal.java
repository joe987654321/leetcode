package leetcode.joe;

import java.util.HashMap;
import java.util.Map;

import leetcode.treenode.TreeNode;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderAndInorderTraversal t = new ConstructBinaryTreefromPreorderAndInorderTraversal();
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode node = t.buildTree(preorder, inorder);
        TreeNode.printTree(node);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return _buildTree(indexMap, preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode _buildTree(Map<Integer, Integer> indexMap, int[] preorder, int preorderS, int[] inorder, int inorderS, int length) {
        if (length == 0) {
            return null;
        }
        TreeNode t = new TreeNode(preorder[preorderS]);
        int index = indexMap.get(preorder[preorderS]);
        int leftLength = index - inorderS;
        int rightLength = length - leftLength -1;

        t.left = _buildTree(indexMap, preorder, preorderS+1, inorder, inorderS, leftLength);
        t.right = _buildTree(indexMap, preorder, preorderS+1+leftLength, inorder, inorderS+leftLength+1, rightLength);
        return t;
    }

}

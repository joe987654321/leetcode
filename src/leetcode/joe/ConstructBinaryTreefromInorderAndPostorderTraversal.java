package leetcode.joe;

import java.util.HashMap;
import java.util.Map;

import leetcode.treenode.TreeNode;

public class ConstructBinaryTreefromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreefromInorderAndPostorderTraversal t = new ConstructBinaryTreefromInorderAndPostorderTraversal();
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};

        TreeNode node = t.buildTree(inorder, postorder);
        TreeNode.printTree(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return _buildTree(map, inorder, 0, postorder, 0, inorder.length);
    }

    private TreeNode _buildTree(Map<Integer, Integer> map, int[] inorder, int inorderS, int[] postorder, int postorderS, int length) {
        if (length == 0) {
            return null;
        }
        TreeNode t = new TreeNode(postorder[postorderS+length-1]);
        int index = map.get(postorder[postorderS+length-1]);

        int leftLength = index - inorderS;
        int rightLength = length - leftLength - 1;

        t.left = _buildTree(map, inorder, inorderS, postorder, postorderS, leftLength);
        t.right = _buildTree(map, inorder, index+1, postorder, postorderS+leftLength, rightLength);
        return t;
    }
}

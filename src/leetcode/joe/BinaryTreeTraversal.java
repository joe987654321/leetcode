package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

import leetcode.treenode.TreeNode;

public class BinaryTreeTraversal {

    public static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            if (root == null) {
                return new ArrayList<Integer>();
            }
            List<Integer> list = new ArrayList<Integer>();
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));

            return list;
        }

        public List<Integer> preorderTraversal(TreeNode root) {

            if (root == null) {
                return new ArrayList<Integer>();
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));

            return list;
        }

        public List<Integer> postorderTraversal(TreeNode root) {

            if (root == null) {
                return new ArrayList<Integer>();
            }
            List<Integer> list = new ArrayList<Integer>();
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);

            return list;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(0);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);

        root.left = a1;
        root.right = a2;
        a1.right = a3;
        a3.left = a4;
        a1.left = a5;
        /*
         *      0
         *     / \
         *    1   2
         *   / \
         *  5   3
         *     /
         *    4
         */
        System.out.println(s.inorderTraversal(root));
        System.out.println(s.preorderTraversal(root));
        System.out.println(s.postorderTraversal(root));
    }
}

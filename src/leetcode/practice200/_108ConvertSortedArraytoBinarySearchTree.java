package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _108ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        _108ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new _108ConvertSortedArraytoBinarySearchTree();
        int [] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = convertSortedArraytoBinarySearchTree.sortedArrayToBST(nums);
        TreeNode.printTree(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return _sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode _sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = _sortedArrayToBST(nums, start, mid);
        root.right = _sortedArrayToBST(nums, mid+1, end);
        return root;
    }
}

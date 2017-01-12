package leetcode.joe;

/**
 * Created by joe321 on 2017/1/9.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode BST(int [] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        if (end == start) {
            return new TreeNode(nums[start]);
        }

        int mid = (end + start)/2;

        TreeNode ret = new TreeNode(nums[mid]);
        ret.left = BST(nums, start, mid -1);
        ret.right = BST(nums, mid + 1, end);

        return ret;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums, 0, nums.length-1);
    }

    public static void printTree(TreeNode t) {
        if (t == null) {
            return;
        }
        printTree(t.left);
        System.out.print(t.val + " ");
        printTree(t.right);
    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new ConvertSortedArraytoBinarySearchTree();

        int [] a = {1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = convertSortedArraytoBinarySearchTree.sortedArrayToBST(a);
        printTree(treeNode);
    }
}

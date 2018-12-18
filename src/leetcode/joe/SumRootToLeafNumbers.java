package leetcode.joe;

import leetcode.treenode.TreeNode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {

        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();

        TreeNode root = TreeNode.createTree(new Integer [] {1,2,3});
        int sum = sumRootToLeafNumbers.sumNumbers(root);
        System.out.println(sum);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int [] sum = {0};
        _sumNumbers(sum, 0, root);
        return sum[0];
    }

    private void _sumNumbers(int[] sum, int now, TreeNode root) {
        now = now*10 + root.val;
        if (root.left == null && root.right == null) {
            sum[0] += now;
            return;
        }
        if (root.left != null) {
            _sumNumbers(sum, now, root.left);
        }
        if (root.right != null) {
            _sumNumbers(sum, now, root.right);
        }
    }

}

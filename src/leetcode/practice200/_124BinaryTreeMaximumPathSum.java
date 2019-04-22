package leetcode.practice200;

import leetcode.treenode.TreeNode;

public class _124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        _124BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new _124BinaryTreeMaximumPathSum();
        TreeNode tree = TreeNode.createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,null,null,1});
        TreeNode.printTree(tree);
        int i = binaryTreeMaximumPathSum.maxPathSum(tree);
        System.out.println(i);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int [] ret = _maxPathSum(root);
        return ret[1];
    }

    private int[] _maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[] {root.val, root.val};
        }
        int leftPathSum = 0;
        int rightPathSum = 0;
        int maxNoLimit = root.val;
        if (root.left != null) {
            int[] left = _maxPathSum(root.left);
            leftPathSum = left[0];
            maxNoLimit = Math.max(maxNoLimit, left[1]);
        }
        if (root.right != null) {
            int[] right = _maxPathSum(root.right);
            rightPathSum = right[0];
            maxNoLimit = Math.max(maxNoLimit, right[1]);
        }
        maxNoLimit = Math.max(
                maxNoLimit,
                root.val + (leftPathSum>0?leftPathSum:0) + (rightPathSum>0?rightPathSum:0)
        );
        int maxWithRoot = root.val + Math.max(Math.max(leftPathSum, rightPathSum),0);
//        System.out.println("root val : " + root.val + " return [" + maxWithRoot + ", " + maxNoLimit + "]");

        return new int[] {maxWithRoot, maxNoLimit};
    }
}

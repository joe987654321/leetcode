package leetcode.joe;

import apple.laf.JRSUIUtils;

import java.util.Arrays;

/**
 * Created by joe321 on 2016/12/30.
 */
public class BinaryTreeMaximumPathSum {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int [] recursiveFindMax(TreeNode node) {
        int rightPathMax = 0;
        int leftPathMax = 0;
        int globalMax = Integer.MIN_VALUE;
        if (node.right != null) {
            int [] rightMax = recursiveFindMax(node.right);
            rightPathMax = rightMax[0];
            if (rightMax[1] > globalMax) {
                globalMax = rightMax[1];
            }
        }

        if (node.left != null) {
            int [] leftMax = recursiveFindMax(node.left);
            leftPathMax = leftMax[0];
            if (leftMax[1] > globalMax) {
                globalMax = leftMax[1];
            }
        }

        int localMax = node.val;
        localMax = Math.max(localMax, node.val + rightPathMax);
        localMax = Math.max(localMax, node.val + leftPathMax);

        if (localMax > globalMax) {
            globalMax = localMax;
        }
        if (node.val + rightPathMax + leftPathMax > globalMax) {
            globalMax = node.val + rightPathMax + leftPathMax;
        }

        //System.out.println("input: at node value = " + node.val);
        //System.out.println("local max = " + localMax + ", globalMax = " + globalMax);
        int [] ret = {localMax, globalMax};
        return ret;
    }

    public int maxPathSum(TreeNode root) {
        int [] max = recursiveFindMax(root);
      //  System.out.println(Arrays.toString(max));
        return max[1];
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(5);
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(8);

        root.right = a1;
        root.left = a2;

        TreeNode b1 = new TreeNode(11);
        //null
        TreeNode b3 = new TreeNode(13);
        TreeNode b4 = new TreeNode(4);

        a1.left = b1;
        a2.left = b3;
        a2.right = b4;

        TreeNode c1 = new TreeNode(7);
        TreeNode c2 = new TreeNode(2);
        TreeNode c8 = new TreeNode(1);

        b1.left = c1;
        b1.right = c2;
        b4.right = c8;

        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }
}

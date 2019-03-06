package leetcode.joe;

import leetcode.treenode.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        TreeNode root = TreeNode.createTree(new Integer[]{1});
        TreeNode.printTree(root);
        int i = countCompleteTreeNodes.countNodes(root);
        System.out.println(i);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int height = 1;
        TreeNode now = root;
        while(now.left != null) {
            height++;
            now = now.left;
        }
        int total = (int)Math.pow(2, height)-1;
        int totalLeave = (int)Math.pow(2, height-1);

        now = root;
        while (height != 1) {
            int leftH = 0;
            TreeNode left = now.left;
            while(left != null) {
                left = left.right;
                leftH++;
            }
            if (leftH == height-1) {
                now = now.right;
            } else {
                now = now.left;
                total -= totalLeave/2;
            }
            height--;
            totalLeave/=2;
        }
        if (now == null) total--;
        return total;
    }
}

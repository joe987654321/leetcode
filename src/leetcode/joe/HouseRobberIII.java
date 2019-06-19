package leetcode.joe;

import leetcode.treenode.TreeNode;

public class HouseRobberIII {
    public static void main(String[] args) {
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        TreeNode.printTree(tree);
        int rob = houseRobberIII.rob(tree);
        System.out.println(rob);

        TreeNode tree2 = TreeNode.createTree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        TreeNode.printTree(tree2);
        int rob2 = houseRobberIII.rob(tree2);
        System.out.println(rob2);
    }

    public int rob(TreeNode root) {
        int [] ret = _rob(root);
        return ret[1];
    }

    private int[] _rob(TreeNode root) {
        if (root == null) return new int[] {0,0};
        int [] left = _rob(root.left);
        int [] right = _rob(root.right);
        int noRob = left[1] + right[1];
        int hasRob = root.val + left[0] + right[0];
        return new int[] {noRob, Math.max(hasRob, noRob)};
    }
}

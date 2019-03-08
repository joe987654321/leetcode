package leetcode.joe;

import leetcode.treenode.TreeNode;

public class KthSmallestElementinaBST {
    public static void main(String[] args) {
        KthSmallestElementinaBST kthSmallestElementinaBST = new KthSmallestElementinaBST();
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 1, 4, null, 2});
        TreeNode.printTree(tree);
        for (int i = 1; i <= 4; i++) {
            int num = kthSmallestElementinaBST.kthSmallest(tree, i);
            System.out.println(num);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        int [] kk = new int[1];
        kk[0] = k;
        Integer tmp = _kthSmallest(root, kk);
        if (tmp != null) return tmp;
        return Integer.MIN_VALUE;
    }

    private Integer _kthSmallest(TreeNode root, int[] kk) {
        if (root.left != null) {
            Integer tmp = _kthSmallest(root.left, kk);
            if (tmp != null) return tmp;
        }
        if (kk[0] == 1) return root.val;
        kk[0]--;
        if (root.right != null) {
            Integer tmp = _kthSmallest(root.right, kk);
            if (tmp != null) return tmp;
        }
        return null;
    }
}

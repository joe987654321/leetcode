package leetcode.practice100;

import leetcode.treenode.TreeNode;

public class _100SameTree {
    public static void main(String[] args) {
        _100SameTree sameTree = new _100SameTree();
        TreeNode t1 = TreeNode.createTree(new Integer[] {1,2,3});
        TreeNode t2 = TreeNode.createTree(new Integer[] {1,2,3});
        boolean b = sameTree.isSameTree(t1, t2);
        System.out.println(b);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        if (!isSameTree(p.right, q.right)) return false;
        return isSameTree(p.left, q.left);
    }
}

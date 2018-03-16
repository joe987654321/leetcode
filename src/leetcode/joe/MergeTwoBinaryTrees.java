package leetcode.joe;

import leetcode.treenode.TreeNode;

/**
 * Created by joe321 on 2017/6/11.
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode ret = new TreeNode(t1.val + t2.val);
        ret.left = mergeTrees(t1.left, t2.left);
        ret.right = mergeTrees(t1.right, t2.right);
        return ret;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        mergeTwoBinaryTrees.mergeTrees(t1, t2);
    }
}

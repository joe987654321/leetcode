package leetcode.practice;

import leetcode.treenode.TreeNode;

public class _099RecoverBinarySearchTree {
    public static void main(String[] args) {
        _099RecoverBinarySearchTree recoverBinarySearchTree = new _099RecoverBinarySearchTree();
        TreeNode t = TreeNode.createTree(new Integer[] {1,3,null,null,2});
        TreeNode.printTree(t);
        recoverBinarySearchTree.recoverTree(t);
        TreeNode.printTree(t);
    }

    public void recoverTree(TreeNode root) {
        TreeNode now = root;

        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;

        while (now != null) {
            if (now.left != null) {
                TreeNode tmp = now.left;
                while (tmp.right != null && tmp.right != now) tmp = tmp.right;
                if (tmp.right == null) {
                    tmp.right = now;
                    now = now.left;
                } else {
                    now = tmp.right;
                    if (pre != null && pre.val > now.val) {
                        if (first == null ) {
                            first = pre;
                        }
                        second = now;
                    }
                    tmp.right = null;
                    pre = now;
                    now = now.right;
                }
            } else {
                if (pre != null && pre.val > now.val) {
                    if (first == null ) {
                        first = pre;
                    }
                    second = now;
                }
                pre = now;
                now = now.right;
            }
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

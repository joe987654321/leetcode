package leetcode.joe;

import leetcode.treelinknode.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {

        TreeLinkNode root = TreeLinkNode.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        TreeLinkNode.printTree(root);
    }

    public void connect(TreeLinkNode root) {
        if (root==null) {
            return;
        }
        connect(root.left);
        connect(root.right);
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while(left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}

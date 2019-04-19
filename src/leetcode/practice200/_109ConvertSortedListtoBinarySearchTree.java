package leetcode.practice200;

import leetcode.listnode.ListNode;
import leetcode.treenode.TreeNode;

public class _109ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {
        _109ConvertSortedListtoBinarySearchTree convertSortedListtoBinarySearchTree = new _109ConvertSortedListtoBinarySearchTree();
        ListNode listNode = ListNode.create(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        TreeNode treeNode = convertSortedListtoBinarySearchTree.sortedListToBST(listNode);
        TreeNode.printTree(treeNode);

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        ListNode [] ref = {head};
        return _toTreeNode(ref, size);
    }

    private TreeNode _toTreeNode(ListNode[] ref, int size) {
        if (size == 0) return null;
        TreeNode root = new TreeNode(0);
        root.left = _toTreeNode(ref, size/2);
        root.val = ref[0].val;
        ref[0] = ref[0].next;
        root.right = _toTreeNode(ref, size - size/2 -1);
        return root;
    }
}

package leetcode.joe;

import leetcode.listnode.ListNode;
import leetcode.treenode.TreeNode;

public class ConvertSortedListtoBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedListtoBinarySearchTree convertSortedListtoBinarySearchTree = new ConvertSortedListtoBinarySearchTree();

        ListNode listRoot = ListNode.create(new int[]{1, 2, 3, 4, 5, 6,7,8,9,10});
        TreeNode treeRoot = convertSortedListtoBinarySearchTree.sortedListToBST(listRoot);
        TreeNode.printTree(treeRoot);
    }

    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode _head = head;
        while(_head != null) {
            _head = _head.next;
            count++;
        }
        return _sortedListToBST(head, count);
    }

    private TreeNode _sortedListToBST(ListNode head, int count) {
        if (count == 0) {
            return null;
        }
        if (count == 1) {
            return new TreeNode(head.val);
        }

        int leftCount = count/2;

        TreeNode left = _sortedListToBST(head, leftCount);
        int tmp = leftCount;
        while (tmp != 0) {
            head = head.next;
            tmp--;
        }

        TreeNode mid = new TreeNode(head.val);
        head = head.next;

        TreeNode right = _sortedListToBST(head, count - leftCount - 1);

        mid.left = left;
        mid.right = right;
        return mid;
    }
}

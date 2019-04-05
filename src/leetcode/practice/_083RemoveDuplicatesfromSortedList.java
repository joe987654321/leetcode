package leetcode.practice;

import leetcode.listnode.ListNode;

public class _083RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        _083RemoveDuplicatesfromSortedList removeDuplicatesfromSortedList = new _083RemoveDuplicatesfromSortedList();
        ListNode root = ListNode.create(new int[] { 1, 1, 2, 3, 4, 4, 5, 5 });
        ListNode.print(root);
        ListNode ret = removeDuplicatesfromSortedList.deleteDuplicates(root);
        ListNode.print(ret);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(0);
        ListNode slow = preHead;
        ListNode now = head;
        while(now != null) {
            if (now.next == null || now.val != now.next.val) {
                slow.next = now;
                slow = slow.next;
            }
            now = now.next;
        }
        return preHead.next;
    }
}

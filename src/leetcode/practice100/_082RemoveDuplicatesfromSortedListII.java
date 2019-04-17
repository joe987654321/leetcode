package leetcode.practice100;

import leetcode.listnode.ListNode;

public class _082RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        _082RemoveDuplicatesfromSortedListII removeDuplicatesfromSortedListII = new _082RemoveDuplicatesfromSortedListII();

        ListNode root = ListNode.create(new int[] {1,2,2});
        ListNode.print(root);

        ListNode ret = removeDuplicatesfromSortedListII.deleteDuplicates(root);
        ListNode.print(ret);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preHead = new ListNode(0);

        ListNode slow = preHead;
        ListNode now = head;
        while (now != null) {
            if (now.next == null || now.next.val != now.val) {
                slow.next = now;
                slow = slow.next;
            } else {
                while(now.next != null && now.next.val == now.val) now = now.next;
            }
            now = now.next;
        }
        slow.next = null;
        return preHead.next;
    }
}

package leetcode.practice100;

import leetcode.listnode.ListNode;

public class _061RotateList {
    public static void main(String[] args) {
        _061RotateList rotateList = new _061RotateList();
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode.print(listNode);
        ListNode listNode1 = rotateList.rotateRight(listNode, 1);
        ListNode.print(listNode1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode slow = head, fast = head;

        int count = 1;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }

        fast = head;
        count = 0;
        while (count != k) {
            fast = fast.next;
            count++;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode ret = slow.next;
        fast.next = head;
        slow.next = null;
        return ret;
    }
}

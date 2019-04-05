package leetcode.practice;

import leetcode.listnode.ListNode;

public class _092ReverseLinkedListII {
    public static void main(String[] args) {
        _092ReverseLinkedListII reverseLinkedListII = new _092ReverseLinkedListII();
        ListNode root = ListNode.create(new int[] { 1, 2, 3, 4, 5 });
        ListNode.print(root);
        ListNode ret = reverseLinkedListII.reverseBetween(root, 1, 5);
        ListNode.print(ret);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode now = preHead;
        n = n - m + 1;
        while (m != 1) {
            now = now.next;
            m--;
        }
        ListNode preHead2 = now;
        ListNode pre = now;
        now = now.next;
        while (n != 0) {
            ListNode tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
            n--;
        }
        preHead2.next.next = now;
        preHead2.next = pre;

        return preHead.next;
    }
}

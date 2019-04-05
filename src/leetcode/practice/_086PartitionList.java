package leetcode.practice;

import leetcode.listnode.ListNode;

public class _086PartitionList {
    public static void main(String[] args) {
        _086PartitionList partitionList = new _086PartitionList();
        ListNode listNode = ListNode.create(new int[]{1, 4, 3, 2, 5, 2});
        ListNode ret = partitionList.partition(listNode, 3);
        ListNode.print(ret);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode preHead1 = new ListNode(0);
        ListNode preHead2 = new ListNode(0);
        ListNode now1 = preHead1, now2 = preHead2, now3 = head;
        while(now3 != null) {
            if (now3.val < x) {
                now1.next = now3;
                now1 = now1.next;
            } else {
                now2.next = now3;
                now2 = now2.next;
            }
            now3 = now3.next;
        }
        now1.next = preHead2.next;
        now2.next = null;
        return preHead1.next;
    }
}

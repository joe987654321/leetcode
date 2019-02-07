package leetcode.practice;

import leetcode.listnode.ListNode;

public class _019RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        _019RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new _019RemoveNthNodeFromEndOfList();
        ListNode input = ListNode.create(new int[] { 1, 2, 3, 4, 5 });
        ListNode output = removeNthNodeFromEndOfList
                .removeNthFromEnd(input, 1);
        ListNode.print(output);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n && second != null; i++) {
            second = second.next;
        }
        if (second == null) {
            return head.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}

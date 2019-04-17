package leetcode.practice100;

import leetcode.listnode.ListNode;

public class _024SwapNodesInPairs {
    public static void main(String[] args) {
        _024SwapNodesInPairs swapNodesInPairs = new _024SwapNodesInPairs();
        ListNode input = ListNode.create(new int[] {1,2,3,4,5});
        ListNode.print(input);
        ListNode ret = swapNodesInPairs.swapPairs(input);;
        ListNode.print(ret);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode now = preHead;
        while (now.next != null && now.next.next != null) {
            ListNode first = now.next;
            ListNode second = now.next.next;
            first.next = second.next;
            second.next = first;
            now.next = second;
            now = now.next.next;
        }
        return preHead.next;
    }
}

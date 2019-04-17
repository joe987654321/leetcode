package leetcode.practice100;

import leetcode.listnode.ListNode;

public class _025ReverseNodesInKGroup {

    public static void main(String[] args) {
        _025ReverseNodesInKGroup reverseNodesInKGroup = new _025ReverseNodesInKGroup();
        ListNode input = ListNode.create(new int[] {1,2,3,4,5,6,7});
        ListNode ret = reverseNodesInKGroup.reverseKGroup(input, 8);
        ListNode.print(ret);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode now = preHead;
        while (true) {
            ListNode tmp = now;
            boolean shouldBreak = false;
            for (int i = 0; i < k; i++) {
                if (tmp.next == null) {
                    shouldBreak = true;
                    break;
                }
                tmp = tmp.next;
            }
            if (shouldBreak) {
                break;
            }

            ListNode pre = now;
            ListNode toFlip = now.next;
            for (int i = 0; i < k; i++) {
                tmp = toFlip.next;
                toFlip.next = pre;
                pre = toFlip;
                toFlip = tmp;
            }

            tmp = now.next;
            now.next = pre;
            tmp.next = toFlip;
            now = tmp;
        }
        return preHead.next;
    }
}

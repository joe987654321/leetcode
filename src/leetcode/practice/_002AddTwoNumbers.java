package leetcode.practice;

import leetcode.listnode.ListNode;

public class _002AddTwoNumbers {
    public static void main(String[] args) {
        _002AddTwoNumbers _002AddTwoNumbers = new _002AddTwoNumbers();
        ListNode ret = _002AddTwoNumbers
                .addTwoNumbers(
                        ListNode.create(new int[] { 9,9,9,9 }),
                        ListNode.create(new int[] { 1 })
                );
        ListNode.print(ret);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preHead = new ListNode(0);
        ListNode now = preHead;
        while (l1 != null || l2 != null) {
            int tmp;
            if (l1 != null && l2 != null) {
                tmp = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                tmp = l1.val + carry;
                l1 = l1.next;
            } else {
                tmp = l2.val + carry;
                l2 = l2.next;
            }

            carry = tmp/10;
            tmp = tmp % 10;

            now.next = new ListNode(tmp);
            now = now.next;
        }
        if (carry != 0) {
            now.next = new ListNode(carry);
        }
        return preHead.next;
    }
}

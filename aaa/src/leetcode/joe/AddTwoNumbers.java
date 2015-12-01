package leetcode.joe;

public class AddTwoNumbers {

   // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode((l1.val + l2.val) % 10);
            ListNode p = head;

            int carry = ((l1.val + l2.val) >= 10) ? 1 : 0 ;
            int l1val;
            int l2val;
            l1 = l1.next;
            l2 = l2.next;
            while(l1 != null || l2 != null || carry != 0) {
                l1val = (l1 == null) ? 0 : l1.val;
                l2val = (l2 == null) ? 0 : l2.val;

//                System.out.println("now number 1 " + l1val);
//                System.out.println("now number 2 " + l2val);
//                System.out.println("now number carry " + carry);
                p.next = new ListNode((l1val + l2val + carry) % 10);
                carry = ((l1val + l2val + carry) >= 10) ? 1 : 0 ;
                p = p.next;
                l1 = (l1 == null) ? null : l1.next ;
                l2 = (l2 == null) ? null : l2.next ;


            }

            return head;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(9);
        ListNode a4 = new ListNode(9);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = null;

        ListNode b1 = new ListNode(8);
        ListNode b2 = new ListNode(7);

        b1.next = b2;
        b2.next = null;

        ListNode n = null;
        n = s.addTwoNumbers(a1, b1);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}

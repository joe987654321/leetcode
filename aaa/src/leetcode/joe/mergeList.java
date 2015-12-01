package leetcode.joe;

public class mergeList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
//        if (l1 == null) {
//            root = new ListNode(l2.val);
//        } else if (l2 == null) {
//            root = new ListNode(l1.val);
//        } else {
//            if (l1.val < l2.val) {
//                root = new ListNode(l1.val);
//            } else {
//                root = new ListNode(l2.val);
//            }
//        }

        ListNode l1now = l1;
        ListNode l2now = l2;
        ListNode head = root;
        while (l1now != null || l2now != null) {
            if (l1now == null) {
                head.next = l2now;
                head = head.next;
                l2now = l2now.next;
            } else if (l2now == null) {
                head.next = l1now;
                head = head.next;
                l1now = l1now.next;
            } else {
                if (l1now.val < l2now.val) {
                    head.next = l1now;
                    head = head.next;
                    l1now = l1now.next;
                } else {
                    head.next = l2now;
                    head = head.next;
                    l2now = l2now.next;
                }
            }
        }
        return root.next;
     }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        ListNode b1 = new ListNode(5);
       // ListNode b2 = new ListNode(4);
       // ListNode b3 = new ListNode(6);


        a1.next = a2;
        a2.next = a3;
       // b1.next = b2;
       // b2.next = b3;
        ListNode c = mergeTwoLists(a1, b1);
        ListNode now = c;
        int count = 0;
        while (now != null && count < 10) {
            System.out.print(now.val + " ");
            now = now.next;
            count++;
        }
        System.out.println("#");
    }
}

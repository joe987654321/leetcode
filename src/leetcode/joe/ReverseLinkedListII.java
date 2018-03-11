package leetcode.joe;

import leetcode.listnode.ListNode;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();

        ListNode root = ListNode.create(new int[] {1,2,3,4,5});
        ListNode.print(root);
        ListNode newRoot = reverseLinkedListII.reverseBetween(root, 1, 5);
        ListNode.print(newRoot);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode preStart;
        if (m == 1) {
            preStart = new ListNode(-1);
            preStart.next = head;
        } else {
            preStart = head;
            for (int i = 0; i < m - 2; i++) {
                preStart = preStart.next;
            }
        }

        ListNode now = preStart.next;
        ListNode nextN = now.next;
        int i = m;
        while(i < n) {
            ListNode tmp = nextN.next;
            nextN.next = now;
            now = nextN;
            nextN = tmp;
            i++;
        }
        preStart.next.next = nextN;
        preStart.next = now;

        return m == 1? preStart.next: head;
    }


}

package leetcode.joe;

import leetcode.listnode.ListNode;

public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {
        IntersectionofTwoLinkedLists intersectionofTwoLinkedLists = new IntersectionofTwoLinkedLists();
        ListNode listNode1 = ListNode.create(new int[]{1, 2, 3});
        ListNode listNode2 = ListNode.create(new int[]{2, 3});
        ListNode listNode3 = ListNode.create(new int[]{4, 5, 6});

        ListNode tmp = listNode1;
        while (tmp.next != null) tmp = tmp.next;
        tmp.next = listNode3;

        tmp = listNode2;
        while (tmp.next != null) tmp = tmp.next;
        tmp.next = listNode3;

        ListNode.print(listNode1);
        ListNode.print(listNode2);

        ListNode intersectionNode = intersectionofTwoLinkedLists.getIntersectionNode(listNode1, listNode2);
        System.out.println(intersectionNode.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int reachNull = 0;
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (reachNull < 3) {
            a = a.next;
            b = b.next;
            if (a == null) {
                a = headB;
                reachNull++;
            }
            if (b == null) {
                b = headA;
                reachNull++;
            }
            if (reachNull == 2 && a == b) {
                return a;
            }
        }
        return null;
    }
}

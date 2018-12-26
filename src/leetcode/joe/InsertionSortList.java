package leetcode.joe;

import leetcode.listnode.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode listNode = ListNode.create(new int[]{7, -1, 5, 3, 4, 0});
        ListNode.print(listNode);
        ListNode ret = insertionSortList.insertionSortList(listNode);
        ListNode.print(ret);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode now = head;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        while (now != null) {
            ListNode tmp = dummyHead;
            ListNode toCompare = now;
            now = now.next;
            while (tmp.next != null && toCompare.val > tmp.next.val) {
                tmp = tmp.next;
            }
            toCompare.next = tmp.next;
            tmp.next = toCompare;
        }
        return dummyHead.next;
    }
}

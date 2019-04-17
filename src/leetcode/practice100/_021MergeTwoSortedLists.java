package leetcode.practice100;

import leetcode.listnode.ListNode;

public class _021MergeTwoSortedLists {
    public static void main(String[] args) {
        _021MergeTwoSortedLists mergeTwoSortedLists = new _021MergeTwoSortedLists();
        ListNode list1 = ListNode.create(new int[] { 1, 3, 5 ,7});
        ListNode list2 = ListNode.create(new int[] { 2, 4, 6 });
        ListNode list3 = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        ListNode.print(list3);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode now = preHead;
        while (l1 != null && l2 != null) {
            if (l2.val > l1.val) {
                now.next = l1;
                now = now.next;
                l1 = l1.next;
                now.next = null;
            } else {
                now.next = l2;
                now = now.next;
                l2 = l2.next;
                now.next = null;
            }
        }
        if (l1 == null) {
            now.next = l2;
        } else {
            now.next = l1;
        }
        return preHead.next;
    }
}

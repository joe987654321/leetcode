package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.listnode.ListNode;

public class _023MergeKSortedLists {
    public static void main(String[] args) {
        _023MergeKSortedLists mergeKSortedLists = new _023MergeKSortedLists();
        ListNode list1 = ListNode.create(new int[] { 1, 4, 5 });
        ListNode list2 = ListNode.create(new int[] { 1, 2, 4 });
        ListNode list3 = ListNode.create(new int[] { 2, 6 });
        ListNode ret = mergeKSortedLists.mergeKLists2(new ListNode[] { list1, list2, list3 });
        ListNode.print(ret);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val < o2.val ? -1 : 1);
        ListNode preHead = new ListNode(0);
        ListNode now = preHead;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            now.next = tmp;
            now = now.next;
            if (tmp.next != null) {
                queue.add(tmp.next);
            }
        }
        return preHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        List<ListNode> nextList = new ArrayList<>();
        for (int i = 0; i+1 < lists.length; i+=2) {
            nextList.add(mergeTwoLists(lists[i], lists[i+1]));
        }
        if (lists.length %2 == 1) {
            nextList.add(lists[lists.length-1]);
        }
        return mergeKLists2(nextList.toArray(new ListNode[0]));
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

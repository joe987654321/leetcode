package leetcode.joe;

import leetcode.listnode.ListNode;

public class SortList {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode listNode = ListNode.create(new int[]{6, -1, 4, 2, -5, 9, 0, 3});
        ListNode.print(listNode);
        ListNode listNode1 = sortList.sortList(listNode);
        ListNode.print(listNode1);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }

        int interval = 2;
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;

        while (interval/2 < size) {
            int leftSize = size;
            tmp = fakeHead;
            while (tmp.next != null) {
                ListNode leaf = move(tmp.next, interval);
                if (leftSize >= interval) {
                    tmp = mergeFromNext(tmp, interval/2, interval/2);
                } else if (leftSize > interval/2) {
                    tmp = mergeFromNext(tmp, interval/2, leftSize - interval/2);
                } else {
                    tmp = move(tmp, leftSize);
                }
                tmp.next = leaf;
                leftSize -= interval;
            }
            interval *= 2;
        }
        return fakeHead.next;
    }

    private ListNode mergeFromNext(ListNode fakeHead, int firstSize, int secondSize) {
        ListNode orig = fakeHead;
        ListNode first = fakeHead.next;
        ListNode tmp = move(fakeHead, firstSize);
        ListNode second = tmp.next;
        tmp.next = null;

        int firstCount = 0;
        int secondCount = 0;
        while (firstCount < firstSize && secondCount < secondSize) {
            if (first.val < second.val) {
                fakeHead.next = first;
                first = first.next;
                firstCount++;
            } else {
                fakeHead.next = second;
                second = second.next;
                secondCount++;
            }
            fakeHead = fakeHead.next;
        }
        while (firstCount < firstSize) {
            fakeHead.next = first;
            first = first.next;
            firstCount++;
            fakeHead = fakeHead.next;
        }
        while(secondCount < secondSize) {
            fakeHead.next = second;
            second = second.next;
            secondCount++;
            fakeHead = fakeHead.next;
        }
        return move(orig, firstCount + secondCount);
    }

    private ListNode move(ListNode head, int count) {
        for (int i = 0; i < count; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        return head;
    }
}

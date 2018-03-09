package leetcode;

import leetcode.listnode.ListNode;

public class PartitionList {

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(2);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(2);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;

        ListNode.printList(ln1);

        PartitionList partitionList = new PartitionList();
        ListNode newRoot = partitionList.partition(ln1,3);

        ListNode.printList(newRoot);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode preNow = root;
        ListNode stored = root;
        while (preNow.next != null) {
            ListNode now = preNow.next;
            if (now.val < x) {
                if (stored.next != now) {
                    preNow.next = now.next;

                    now.next = stored.next;
                    stored.next = now;
                } else {
                    preNow = preNow.next;
                }
                stored = stored.next;
            } else {
                preNow = preNow.next;
            }
        }
        return root.next;
    }
}

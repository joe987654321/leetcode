package leetcode.joe;

import leetcode.listnode.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();

        ListNode root = ListNode.create(new int[]{1, 2, 3, 4});
        ListNode.print(root);
        reorderList.reorderList(root);
        ListNode.print(root);
    }

    public void reorderList(ListNode head) {
        int size = 0;
        ListNode now = head;
        while (now!=null) {
            now = now.next;
            size++;
        }
        if (size <= 1) {
            return;
        }
        int secondSize = size/2;
        now = head;
        int nowIndex = 1;
        while (nowIndex != size - secondSize) {
            now = now.next;
            nowIndex++;
        }

        ListNode secondHead = now.next;
        now.next = null;

        ListNode pre = null;
        now = secondHead;
        while (now != null) {
            ListNode tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
        }
        secondHead = pre;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = secondHead;
            head = tmp;
            if (secondHead == null) {
                break;
            }
            tmp = secondHead.next;
            secondHead.next = head;
            secondHead = tmp;
        }
    }
}

package leetcode.joe;

import leetcode.listnode.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int preVal = head.val;
        ListNode preNode = head;
        ListNode current = head.next;
        while (current != null) {
            if (preVal != current.val) {
                preVal = current.val;
                preNode = current;
            } else {
                preNode.next = current.next;
            }
            current = current.next;
        }
        return head;
    }

    private static ListNode getTestList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        int [] a = {1,1,1,1,1,2,5};

        ListNode head = getTestList(a);
        ListNode out = removeDuplicatesFromSortedList.deleteDuplicates(head);
        ListNode.printList(out);
    }
}

package leetcode.joe;

import leetcode.listnode.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode newListCurrent = null;
        ListNode candidate = head;
        int preVal = head.val;
        ListNode current = head.next;
        while (current != null) {
            if (preVal == current.val) {
                candidate = null;
            } else {
                if (candidate != null) {
                    if (newHead == null) {
                        newHead = newListCurrent = candidate;
                    } else {
                        newListCurrent.next = candidate;
                        newListCurrent = candidate;
                    }
                }
                candidate = current;
                preVal = current.val;
            }
            current = current.next;
        }

        if (candidate != null) {
            if (newHead == null) {
                newHead = candidate;
            } else {
                newListCurrent.next = candidate;
            }
            candidate.next = null;
        } else if (newListCurrent != null) {
            newListCurrent.next = null;
        }
        return newHead;
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
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedListII();
        int [] a = {1,1,2,3,3,4,5,5,5,6};
        int [] b = {1,2,2};

        ListNode head = getTestList(b);
        ListNode out = removeDuplicatesFromSortedList.deleteDuplicates(head);
        ListNode.print(out);
    }
}

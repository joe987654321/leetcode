package leetcode.joe;

/**
 * Created by joe321 on 2017/4/20.
 */
public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        while (n != -1) {
            if (second == null) {
                return head.next;
            }
            second = second.next;
            n--;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();

        ListNode [] a = new ListNode[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = new ListNode(a.length-i);
            if (i != 0) {
                a[i-1].next = a[i];
            }
        }


        printList(a[0]);
        ListNode ret = removeNthNodeFromEndOfList.removeNthFromEnd(a[0], 3);
        printList(ret);
    }

    private static void printList(ListNode listNode) {
        System.out.print("List: ");
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println("");
    }
}

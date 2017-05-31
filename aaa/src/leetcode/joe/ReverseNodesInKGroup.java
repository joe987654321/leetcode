package leetcode.joe;

/**
 * Created by joe321 on 2017/5/26.
 */
public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) {
            return head;
        }

        ListNode preUnfinishedHead = null;
        ListNode unfinishedHead = head;
        ListNode ret = head;
        while (true) {

            ListNode end = unfinishedHead;
            for (int i = 0; i < k; i++) {
                if (end == null) {
                    return ret;
                }
                end = end.next;
            }

            //System.out.println("end is " + end.val);


            /* ex: 1->2->3->4->5, k=2
               1st round: preUnfinishedHead = null, end = 3, nextPreUnfinishedHead should be 1 == unfinishedHead
                   reverse head->1->2->end to head->2->1->end, set ret to 2
               now: 2->1->3->4->5
               2nd round: preUnfinishedHead = 1, end = 5, nextPreUnfinishedHead should be 3 == unfinishedHead
                   reverse preUnfinishedHead->3->4->end to preUnfinishedHead->4->3->end, ret no change
               now: 2->1->4->3->5
               3nd round: left number of node < 2, no change needed, return ret
             */

            ListNode nextPreUnfinishedHead = unfinishedHead;

            ListNode one = unfinishedHead;
            ListNode two = end;
            for (int i = 0; i < k; i++) {
              //  System.out.println("one two: " + one.val + " " + two.val);

                ListNode tmp = one.next;
                one.next = two;

                two = one;
                one = tmp;
            }

            if (preUnfinishedHead != null) {
                preUnfinishedHead.next = two;
            } else {
                ret = two;
            }

//            printNode(head);

            preUnfinishedHead = nextPreUnfinishedHead;
            unfinishedHead = end;
        }
    }

    private void printNode(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "->");
            root = root.next;
        }
        System.out.println("null");
    }

    private static ListNode prepareListNodes() {
        int length = 5;
        ListNode[]  listNodes = new ListNode[length];
        for (int i = 0; i < length; i++) {
            listNodes[i] = new ListNode(i+1);
            if (i>0) {
                listNodes[i-1].next = listNodes[i];
            }
        }
        return listNodes[0];
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();

        System.out.println("orig:");
        reverseNodesInKGroup.printNode(prepareListNodes());
        System.out.println("");
        reverseNodesInKGroup.printNode(reverseNodesInKGroup.reverseKGroup(prepareListNodes(), 1));
        reverseNodesInKGroup.printNode(reverseNodesInKGroup.reverseKGroup(prepareListNodes(), 2));
        reverseNodesInKGroup.printNode(reverseNodesInKGroup.reverseKGroup(prepareListNodes(), 3));
        reverseNodesInKGroup.printNode(reverseNodesInKGroup.reverseKGroup(prepareListNodes(), 4));
        reverseNodesInKGroup.printNode(reverseNodesInKGroup.reverseKGroup(prepareListNodes(), 5));
        reverseNodesInKGroup.printNode(reverseNodesInKGroup.reverseKGroup(prepareListNodes(), 6));
    }
}

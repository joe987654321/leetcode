package leetcode.listnode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode create(int [] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode root = new ListNode(vals[0]);
        ListNode now = root;
        for (int i = 1; i < vals.length; i++) {
            now.next = new ListNode(vals[i]);
            now = now.next;
        }
        return root;
    }

    public static void print(ListNode node) {
        ListNode now = node ;
        while (now != null) {
            System.out.print(now.val + "->");
            now = now.next;
        }
        System.out.println("null");
    }
}
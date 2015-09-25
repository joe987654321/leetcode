package com.yahoo.nevec.egs.product.consumer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists {
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class Solution {
        public class Node {
            int val;
            int index;
            Node(int v, int i) { val = v; index = i;}
        }

        public class nodeComparator implements Comparator<Node> {
            @Override
            public int compare(Node x, Node y)
            {
                if (x.val < y.val) {
                    return -1;
                } else if (x.val > y.val) {
                    return 1;
                } else {
                    return 0;
                }
            }

        }

        public ListNode mergeKLists(ListNode[] lists) {

            Comparator<Node> c = new nodeComparator();

            PriorityQueue<Node> heap = new PriorityQueue<Node>(c);

            int i = 0;
            for (i=0;i<lists.length;i++) {
                if (lists[i] != null) {
                    heap.add(new Node(lists[i].val, i));
                }
            }
            for (i=0;i<lists.length;i++) {
                if (lists[i] != null) {
                    lists[i] = lists[i].next;
                }
            }

            ListNode head = new ListNode(0);
            ListNode p = head;
            while (heap.size() > 0) {
                Node n = heap.poll();
                p.next = new ListNode(n.val);
                p = p.next;
                if (lists[n.index] != null) {
                    heap.add(new Node(lists[n.index].val, n.index));
                    lists[n.index] = lists[n.index].next;
                }
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(9);

        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(8);

        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);

        ListNode d1 = null;

        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        c1.next = c2;

        ListNode[] lists = new ListNode[3];
        lists[0] = a1;
        lists[1] = b1;
        lists[2] = d1;

        Solution s = new Solution();
        ListNode ret = s.mergeKLists(lists);

        while(ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }
}

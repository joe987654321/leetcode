package leetcode.practice200;

public class _117PopulatingNextRightPointersinEachNodeII {
    public static void main(String[] args) {
        Node n = new Node(1,
                new Node(2,
                        new Node(4,null,null,null),
                        new Node(5,null,null,null),
                        null
                ),
                new Node(3,
                        null,
                        new Node(7,null,null,null),
                        null
                ),
                null
        );

        _117PopulatingNextRightPointersinEachNodeII populatingNextRightPointersinEachNodeII = new _117PopulatingNextRightPointersinEachNodeII();
        populatingNextRightPointersinEachNodeII.connect(n);
    }

    public Node connect(Node root) {
        Node pre1 = new Node(0, null, null, root);
        Node pre2 = new Node(0, null, null, null);
        while (pre1.next != null) {
            Node now = pre1.next;
            Node nextCol = pre2;
            while (now != null) {
                if (now.left != null) {
                    nextCol.next = now.left;
                    nextCol = nextCol.next;
                }
                if (now.right != null) {
                    nextCol.next = now.right;
                    nextCol = nextCol.next;
                }
                now = now.next;
            }
            pre1.next = pre2.next;
            pre2.next = null;
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

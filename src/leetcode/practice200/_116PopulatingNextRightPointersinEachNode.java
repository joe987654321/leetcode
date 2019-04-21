package leetcode.practice200;

public class _116PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        Node n = new Node(1,
            new Node(2,
                new Node(4,null,null,null),
                new Node(5,null,null,null),
                null
            ),
            new Node(3,
                new Node(6,null,null,null),
                new Node(7,null,null,null),
                null
            ),
            null
        );
        _116PopulatingNextRightPointersinEachNode populatingNextRightPointersinEachNode = new _116PopulatingNextRightPointersinEachNode();
        populatingNextRightPointersinEachNode.connect(n);

    }

    public Node connect(Node root) {
        if (root == null) return root;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
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

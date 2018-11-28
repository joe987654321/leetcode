package leetcode.joe;

import leetcode.treelinknode.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {

        //TreeLinkNode root = TreeLinkNode.createTree(new Integer[] { 1, 2, 3, 4, 5, null, 6, 7,null,null,null,null,null,null,8 });
        TreeLinkNode root = TreeLinkNode.createTree(new Integer[] { 3,9,20,null,null,15,7 });
        TreeLinkNode.printTree(root);

        PopulatingNextRightPointersInEachNodeII populatingNextRightPointersInEachNodeII = new PopulatingNextRightPointersInEachNodeII();
        populatingNextRightPointersInEachNodeII.connect(root);
        System.out.println(root.left.next.val);
        System.out.println(root.right.left.next.val);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode head = new TreeLinkNode(0);
        TreeLinkNode t = head;
        TreeLinkNode now = root;
        while (true) {
            if (now.left != null) {
                t.next = now.left;
                t = t.next;
            }
            if (now.right != null) {
                t.next = now.right;
                t = t.next;
            }
            now = now.next;
            if (now == null) {
                if (head.next == null) {
                    break;
                }
                now = head.next;
                t = head;
                head.next = null;
            }
        }
    }

    public void connectSlow(TreeLinkNode root) {
        if (root==null) {
            return;
        }
        connectSlow(root.left);
        connectSlow(root.right);
        TreeLinkNode leftStart = root.left;
        TreeLinkNode rightStart = root.right;
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while (left != null && right != null) {
            while (leftStart != null) {
                if (leftStart.left == null && leftStart.right == null) {
                    leftStart = leftStart.next;
                } else {
                    if (leftStart.left != null) {
                        leftStart = leftStart.left;
                    } else {
                        leftStart = leftStart.right;
                    }
                    break;
                }
            }

            if (leftStart == null) {
                left.next = right;
                return;
            }

            TreeLinkNode nextLeft = leftStart;
            while (nextLeft.next != null) {
                nextLeft = nextLeft.next;
            }

            while (rightStart != null) {
                if (rightStart.left == null && rightStart.right == null) {
                    rightStart = rightStart.next;
                } else {
                    if (rightStart.left != null) {
                        rightStart = rightStart.left;
                    } else {
                        rightStart = rightStart.right;
                    }
                    break;
                }
            }
            TreeLinkNode nextRight = rightStart;

            left.next = right;
            left = nextLeft;
            right = nextRight;
        }
    }

}

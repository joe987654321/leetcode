package leetcode.treelinknode;

import java.util.*;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;
    public TreeLinkNode(int x) { val = x; }

    public static TreeLinkNode createTree(Integer [] input) {
        if (input.length == 0) {
            throw new RuntimeException("invalid input");
        }
        if (input.length == 1 && input[0] == null) {
            return null;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(input[0]);
        queue.add(root);
        for (int i = 1; i < input.length; i++) {
            TreeLinkNode top = queue.peek();
            if (input[i] != null) {
                if (top == null) {
                    throw new RuntimeException("invalid input");
                }
                TreeLinkNode n = new TreeLinkNode(input[i]);
                if (i % 2 == 1) {
                    top.left = n;
                } else {
                    top.right = n;
                    queue.poll();
                }
                queue.add(n);
            } else {
                if (i % 2 == 0) {
                    queue.poll();
                }
                queue.add(null);
            }
        }
        return root;
    }

    public static void printTreeStraight(TreeLinkNode root) {
        if (root == null) {
            System.out.print("null");
            return;
        }
        System.out.print(root.val + " ");
        printTreeStraight(root.left);
        System.out.print(" ");
        printTreeStraight(root.right);
    }

    public static <T extends Comparable<?>> void printTree(TreeLinkNode root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeLinkNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeLinkNode> newNodes = new ArrayList<>();
        for (TreeLinkNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeLinkNode node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

//    public static void printTree(TreeNode root) {
//        printTree(root, "", true);
//    }
//
//    private static void printTree(TreeNode root, String prefix, boolean isTail) {
//        System.out.println(prefix + (isTail ? "└── " : "├── ") + root.val);
//        List<TreeNode> children = new ArrayList<>();
//        if (root.right != null) {
//            children.add(root.right);
//        }
//        if (root.left != null) {
//            children.add(root.left);
//        }
//
//        for (int i = 0; i < children.size() - 1; i++) {
//            printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
//        }
//        if (children.size() > 0) {
//            printTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
//        }
//    }
}

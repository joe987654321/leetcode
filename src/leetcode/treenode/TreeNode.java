package leetcode.treenode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode createTree(Integer [] input) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(input[0]);
        queue.add(root);
        for (int i = 1; i < input.length; i++) {
            TreeNode top = queue.peek();
            if (input[i] != null) {
                if (top == null) {
                    throw new RuntimeException("invalid input");
                }
                TreeNode n = new TreeNode(input[i]);
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

    public static void printTreeStraight(TreeNode root) {
        if (root == null) {
            System.out.print("null");
            return;
        }
        System.out.print(root.val + " ");
        printTreeStraight(root.left);
        System.out.print(" ");
        printTreeStraight(root.right);
    }

    public static <T extends Comparable<?>> void printTree(TreeNode root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
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

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
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

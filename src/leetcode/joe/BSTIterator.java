package leetcode.joe;

import java.util.Stack;

import leetcode.treenode.TreeNode;

public class BSTIterator {

    Stack<TreeNode> stack;

    private void insertStack(TreeNode node) {
        if (node != null) {
            stack.push(node);
       //     System.out.println("push " + node.val);
            insertStack(node.left);
        }
    }

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        insertStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        insertStack(node.right);
        return node.val;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);
        tn3.left = tn2;
        tn2.left = tn1;
        tn3.right = tn6;
        tn6.left = tn4;
        tn4.right = tn5;
        tn6.right = tn7;
        tn7.right = tn8;

        BSTIterator b = new BSTIterator(tn3);

//        System.out.println(b.next());
//        System.out.println(b.next());
//        System.out.println(b.next());
//        System.out.println(b.next());
        while (b.hasNext()) System.out.println(b.next());
    }

}
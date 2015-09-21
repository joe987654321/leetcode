package com.yahoo.nevec.egs.product.consumer;

import java.util.Stack;

public class BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null; }
    }

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

        BSTIterator.TreeNode tn1 = new BSTIterator.TreeNode(1);
        BSTIterator.TreeNode tn2 = new BSTIterator.TreeNode(2);
        BSTIterator.TreeNode tn3 = new BSTIterator.TreeNode(3);
        BSTIterator.TreeNode tn4 = new BSTIterator.TreeNode(4);
        BSTIterator.TreeNode tn5 = new BSTIterator.TreeNode(5);
        BSTIterator.TreeNode tn6 = new BSTIterator.TreeNode(6);
        BSTIterator.TreeNode tn7 = new BSTIterator.TreeNode(7);
        BSTIterator.TreeNode tn8 = new BSTIterator.TreeNode(8);
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
package leetcode.joe;

import leetcode.treenode.TreeNode;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        /*
              3
             / \
            1   4
               /
              2
         */

        TreeNode.printTree(root);
        recoverBinarySearchTree.recoverTree(root);
        TreeNode.printTreeStraight(root);
        System.out.println("");
        TreeNode.printTree(root);
    }

    public void recoverTree(TreeNode root) {
        TreeNode preNode = null;
        TreeNode currentNode = root;
        TreeNode firstFind = null;
        TreeNode secondFind = null;

        while(currentNode != null) {
            if (currentNode.left != null) {
                //link current node with left tree, then go left
                //if find circle, break the circle, output current, and go right
                TreeNode next = currentNode.left;
                while (next.right != null && next.right != currentNode) {
                    next = next.right;
                }

                if (next.right == null) {
                    next.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    //break the circle
                    next.right = null;
                    if (preNode != null && preNode.val > currentNode.val) {
                        if (firstFind == null) {
                            firstFind = preNode;
                        }
                        secondFind = currentNode;
                    }
                    preNode = currentNode;
                    currentNode = currentNode.right;
                }
            } else {
                if (preNode != null && preNode.val > currentNode.val) {
                    if (firstFind == null) {
                        firstFind = preNode;
                    }
                    secondFind = currentNode;
                }
                preNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        if (firstFind != null) {
            int tmp = firstFind.val;
            firstFind.val = secondFind.val;
            secondFind.val = tmp;
        }
    }
}

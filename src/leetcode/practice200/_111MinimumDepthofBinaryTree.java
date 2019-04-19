package leetcode.practice200;

import java.util.Stack;

import leetcode.treenode.TreeNode;

public class _111MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        _111MinimumDepthofBinaryTree minimumDepthofBinaryTree = new _111MinimumDepthofBinaryTree();
        TreeNode tree = TreeNode.createTree(new Integer[]
                {1,2,3,4,null,null,5});
        int depth = minimumDepthofBinaryTree.minDepth(tree);
        System.out.println(depth);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextS = new Stack<>();
        stack.push(root);
        int nowLevel = 1;
        while (true) {
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                System.out.println(t.val + ", now level is " + nowLevel);
                if (t.left == null && t.right == null) return nowLevel;
                if (t.left != null) nextS.push(t.left);
                if (t.right != null) nextS.push(t.right);
            }
            System.out.println(nextS);
            nowLevel++;
            Stack<TreeNode> tmp = nextS;
            nextS = stack;
            stack = tmp;

        }
    }
}

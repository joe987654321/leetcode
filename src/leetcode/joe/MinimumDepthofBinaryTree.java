package leetcode.joe;

import leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode.printTree(tree);
        System.out.println(new MinimumDepthofBinaryTree().minDepth(tree));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        current.add(root);
        int level = 1;
        while(true) {
            while (!current.isEmpty()) {
                TreeNode now = current.get(0);
                if (now.left == null && now.right == null) {
                    return level;
                }
                if (now.left != null) {
                    next.add(now.left);
                }
                if (now.right != null) {
                    next.add(now.right);
                }
                current.remove(0);
            }
            level++;
            List<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }
    }
}

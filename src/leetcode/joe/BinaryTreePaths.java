package leetcode.joe;

import leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode tree = TreeNode.createTree(new Integer[]{1, 2, 3, null, 5});
        TreeNode.printTree(tree);
        List<String> strings = binaryTreePaths.binaryTreePaths(tree);
        System.out.println(strings);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) return ret;
        if (root.left == null && root.right == null) {
            ret.add("" + root.val);
            return ret;
        }
        if (root.left != null) {
            for (String s : binaryTreePaths(root.left)) {
                ret.add(root.val + "->" + s);
            }
        }
        if (root.right != null) {
            for (String s : binaryTreePaths(root.right)) {
                ret.add(root.val + "->" + s);
            }
        }
        return ret;
    }
}

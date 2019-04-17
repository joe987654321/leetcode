package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

import leetcode.treenode.TreeNode;

public class _094BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        _094BinaryTreeInorderTraversal binaryTreeInorderTraversal = new _094BinaryTreeInorderTraversal();
        TreeNode tree = TreeNode.createTree(new Integer[] { 1, null, 2, null, null, 3 });
        TreeNode.printTree(tree);
        List<Integer> integers = binaryTreeInorderTraversal.inorderTraversal(tree);
        System.out.println(integers);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;

        List<Integer> tmp = inorderTraversal(root.left);
        if (!tmp.isEmpty()) ret.addAll(tmp);
        ret.add(root.val);
        tmp = inorderTraversal(root.right);
        if (!tmp.isEmpty()) ret.addAll(tmp);

        return ret;
    }
}

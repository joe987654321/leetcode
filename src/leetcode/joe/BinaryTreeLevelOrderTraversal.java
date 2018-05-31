package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

import leetcode.treenode.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();

        Integer[] values = {3,9,20,null,null,15,7};
        //Integer[] values = {};
        TreeNode root = TreeNode.createTree(values);

        List<List<Integer>> lists = binaryTreeLevelOrderTraversal.levelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        _levelOrder(ret, root, 0);
        return ret;
    }

    private void _levelOrder(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ret.size()-1 < level) {
            ret.add(new ArrayList<>());
        }
        ret.get(level).add(root.val);
        _levelOrder(ret, root.left, level+1);
        _levelOrder(ret, root.right, level+1);
    }

}

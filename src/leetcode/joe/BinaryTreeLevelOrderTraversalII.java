package leetcode.joe;

import leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();

        Integer[] values = {3,9,20,null,null,15,7};
        //Integer[] values = {};
        TreeNode root = TreeNode.createTree(values);

        List<List<Integer>> lists = binaryTreeLevelOrderTraversalII.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        _levelOrder(ret, root, 0);
        for (int i = 0; i < ret.size()/2; i++) {
            List<Integer> tmp = ret.get(i);
            ret.set(i, ret.get(ret.size()-1-i));
            ret.set(ret.size()-1-i, tmp);
        }
        return ret;
    }

    public void _levelOrder(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ret.size() <= level) {
            ret.add(new ArrayList<>());
        }
        ret.get(level).add(root.val);
        _levelOrder(ret, root.left, level+1);
        _levelOrder(ret, root.right, level+1);
    }

}

package leetcode.practice200;

import java.util.ArrayList;
import java.util.List;

import leetcode.treenode.TreeNode;

public class _113PathSumII {
    public static void main(String[] args) {
        _113PathSumII pathSumII = new _113PathSumII();
        TreeNode tree = TreeNode
                .createTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1 });
        List<List<Integer>> lists = pathSumII.pathSum(tree, 22);
        System.out.println(lists);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        if (root.left == null && root.right == null && sum == root.val) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            ret.add(tmp);
            return ret;
        }
        List<List<Integer>> ret1 = pathSum(root.left, sum - root.val);
        if (!ret1.isEmpty()) {
            for (List<Integer> list: ret1) {
                list.add(0, root.val);
                ret.add(list);
            }
        }
        ret1 = pathSum(root.right, sum - root.val);
        if (!ret1.isEmpty()) {
            for (List<Integer> list: ret1) {
                list.add(0, root.val);
                ret.add(list);
            }
        }
        return ret;
    }
}

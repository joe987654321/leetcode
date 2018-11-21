package leetcode.joe;

import leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,null,5,1});
        TreeNode.printTree(root);
        PathSumII pathSumII = new PathSumII();
        List<List<Integer>> lists = pathSumII.pathSum(root, 22);
        System.out.println(lists);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        _pathSum(ret, new ArrayList<>(), root, sum);
        return ret;
    }

    private void _pathSum(List<List<Integer>> ret, List<Integer> now, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        now.add(root.val);
        if (root.right == null && root.left == null && sum == root.val) {
            List<Integer> tmp = new ArrayList<>(now);
            ret.add(tmp);
        } else {
            _pathSum(ret, now, root.right, sum - root.val);
            _pathSum(ret, now, root.left, sum - root.val);
        }
        now.remove(now.size()-1);
    }
}

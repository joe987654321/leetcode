package leetcode.practice200;

import leetcode.treenode.TreeNode;

import java.util.*;

public class _102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        _102BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new _102BinaryTreeLevelOrderTraversal();
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> lists = binaryTreeLevelOrderTraversal.levelOrder(tree);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queueNow = new LinkedList<>();
        Queue<TreeNode> queueNext = new LinkedList<>();
        queueNow.add(root);
        ret.add(Collections.singletonList(root.val));
        while (!queueNow.isEmpty()) {
            ret.add(new ArrayList<>());
            while (!queueNow.isEmpty()) {
                TreeNode tn = queueNow.poll();
                if (tn.left != null) {
                    ret.get(ret.size()-1).add(tn.left.val);
                    queueNext.add(tn.left);
                }
                if (tn.right != null) {
                    ret.get(ret.size()-1).add(tn.right.val);
                    queueNext.add(tn.right);
                }
            }
            Queue<TreeNode> tmp = queueNow;
            queueNow = queueNext;
            queueNext = tmp;
        }
        ret.remove(ret.size()-1);
        return ret;
    }
}

package leetcode.practice200;

import leetcode.treenode.TreeNode;

import java.util.*;

public class _103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        _103BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new _103BinaryTreeZigzagLevelOrderTraversal();
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> ret = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(tree);
        System.out.println(ret);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for (int i = 1; i < ret.size(); i+=2) {
            Collections.reverse(ret.get(i));
        }
        return ret;
    }
}

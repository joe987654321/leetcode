package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

import leetcode.treenode.TreeNode;

public class BinaryTreeZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigZagLevelOrderTraversal binaryTreeZigZagLevelOrderTraversal = new BinaryTreeZigZagLevelOrderTraversal();
        Integer [] input = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createTree(input);
        List<List<Integer>> ret = binaryTreeZigZagLevelOrderTraversal.zigzagLevelOrder(root);
        System.out.println(ret);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root==null) {
            return ret;
        }
        List<TreeNode> preList = new ArrayList<>();
        List<TreeNode> nextList = new ArrayList<>();

        preList.add(root);
        int nowLevel = 0;
        while(!preList.isEmpty()) {
            ret.add(new ArrayList<>());
            for (TreeNode t: preList) {
                if (nowLevel %2 ==0) {
                    ret.get(nowLevel).add(t.val);
                } else {
                    ret.get(nowLevel).add(0, t.val);
                }
                if (t.left != null) {
                    nextList.add(t.left);
                }
                if (t.right != null) {
                    nextList.add(t.right);
                }
            }
            preList.clear();
            List tmp = preList;
            preList = nextList;
            nextList = tmp;
            nowLevel++;
        }
        return ret;
    }
}

package leetcode.joe;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.treenode.TreeNode;

public class BinaryTreerightSideview {

    public class Solution {

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            if (root == null) {
                return list;
            }
            list.add(root.val);
            List<Integer> leftRet = rightSideView(root.left);
            List<Integer> rightRet = rightSideView(root.right);
            list.addAll(rightRet);
            if (rightRet.size() < leftRet.size()) {
                list.addAll(leftRet.subList(rightRet.size(), leftRet.size()));
            }
            return list;
        }
    }

}

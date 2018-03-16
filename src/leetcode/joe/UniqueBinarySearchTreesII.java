package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import leetcode.treenode.TreeNode;

public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {

        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        List<TreeNode> treeNodes = uniqueBinarySearchTreesII.generateTrees(3);

        for (int i = 0; i < treeNodes.size(); i++) {
            System.out.println("root is " + treeNodes.get(i).val);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return _generateTrees(1, n);
    }

    private List<TreeNode> _generateTrees(int start, int end) {
        if (end < start) {
            return Collections.singletonList(null);
        }
        if (start == end) {
            return Collections.singletonList(new TreeNode(start));
        }

        List<TreeNode> ret = new ArrayList<>();

        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTreeNodes = _generateTrees(start, i-1);
            List<TreeNode> rightTreeNodes = _generateTrees(i+1 , end);

            for (int j = 0; j < leftTreeNodes.size(); j++) {
                for (int k = 0; k < rightTreeNodes.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTreeNodes.get(j);
                    root.right = rightTreeNodes.get(k);

                    ret.add(root);
                }
            }
        }
        return ret;
    }
}

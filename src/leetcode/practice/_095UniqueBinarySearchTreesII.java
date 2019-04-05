package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

import leetcode.treenode.TreeNode;

public class _095UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        _095UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new _095UniqueBinarySearchTreesII();
        List<TreeNode> treeNodes = uniqueBinarySearchTreesII.generateTrees(5);
        for (TreeNode tn : treeNodes) {
            TreeNode.printTree(tn);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return _generate(n, 1);
    }

    private List<TreeNode> _generate(int n, int start) {
        List<TreeNode> ret = new ArrayList<>();
        if (n == 0) {
            ret.add(null);
            return ret;
        }
        if (n == 1) {
            ret.add(new TreeNode(start));
            return ret;
        }
        for (int i = 0 ; i < n; i++) {
            List<TreeNode> left = _generate(i, start);
            List<TreeNode> right = _generate(n-i-1, start+i+1);
            for (TreeNode ll: left) {
                for (TreeNode rr: right) {
                    TreeNode t = new TreeNode(start+i);
                    t.right = rr;
                    t.left = ll;
                    ret.add(t);
                }
            }
        }
        return ret;
    }
}

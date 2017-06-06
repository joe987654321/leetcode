package leetcode.joe;

/**
 * Created by Joe on 2017/6/4.
 */
public class ConstructStringfromBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private String construct(TreeNode t) {
        if (t==null) {
            return "";
        }
        String tl = construct(t.left);
        String tr = construct(t.right);
        if (tl.isEmpty() && !tr.isEmpty()) {
            tl = "()";
        }

        return "(" + t.val + tl + tr + ")";

    }

    public String tree2str(TreeNode t) {
        if (t==null) {
            return "";
        }
        String a = "" + t.val;
        String tl = construct(t.left);
        String tr = construct(t.right);
        if (tl.isEmpty() && !tr.isEmpty()) {
            tl = "()";
        }

        return a + tl + tr;
    }

    public static void main(String[] args) {
        ConstructStringfromBinaryTree constructStringfromBinaryTree = new ConstructStringfromBinaryTree();
        TreeNode t1 = new TreeNode(1);
       // t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.right.left = new TreeNode(4);
        System.out.println(constructStringfromBinaryTree.tree2str(t1));
    }
}

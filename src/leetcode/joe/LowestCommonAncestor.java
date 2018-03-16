package leetcode.joe;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import leetcode.treenode.TreeNode;

/**
 * Created by joe321 on 2017/5/23.
 */
public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (p == q) {
            return p;
        }
        List<TreeNode> pathNow = new ArrayList<>();
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        TreeNode now = root;
        //pathNow.add(root);
        traceTree(now, pathNow, pathP, pathQ, p , q);
//        printList(pathP);
//        printList(pathQ);
        TreeNode ret;
        int index = 1;
        while (true) {
            if (pathP.size() == index || pathQ.size() == index || pathP.get(index) != pathQ.get(index)) {
                return pathP.get(index-1);
            }
            index++;
        }

    }

    private void traceTree(TreeNode now, List<TreeNode> pathNow, List<TreeNode> pathP, List<TreeNode> pathQ, TreeNode p, TreeNode q) {

        if (!pathP.isEmpty() && !pathQ.isEmpty()) {
            return;
        }
        if (now == p) {
            pathP.addAll(pathNow);
            pathP.add(now);
        }
        if (now == q) {
            pathQ.addAll(pathNow);
            pathQ.add(now);
        }
        pathNow.add(now);
        if (now.left != null) {
            traceTree(now.left, pathNow, pathP, pathQ, p, q);
        }
        if (now.right != null) {
            traceTree(now.right, pathNow, pathP, pathQ, p, q);
        }
        pathNow.remove(pathNow.size()-1);
    }

    private void printList(List<TreeNode> ts) {
        ListIterator<TreeNode> treeNodeListIterator = ts.listIterator();

        while(treeNodeListIterator.hasNext()) {
            System.out.print(treeNodeListIterator.next().val + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        /*
                t1
             t2    t3
           t4 t5  X  X
         */


        System.out.println(lowestCommonAncestor.lowestCommonAncestor(t1, t1, t5).val);
    }
}

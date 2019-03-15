package leetcode.joe;

import leetcode.treenode.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[] {1,2,3,null,null,4,5,null,null,null,null,6,7});
        TreeNode.printTree(tree);
        Codec codec = new Codec();
        String serialize = codec.serialize(tree);

        System.out.println(serialize);

        TreeNode tree2 = codec.deserialize(serialize);
        TreeNode.printTree(tree2);

    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            list.add(root.val);
            while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.add(t.left);
                    list.add(t.left.val);
                } else {
                    list.add(null);
                }

                if (t.right != null) {
                    queue.add(t.right);
                    list.add(t.right.val);
                } else {
                    list.add(null);
                }
            }
            int last = list.size()-1;
            while (list.get(last) == null) {
                list.remove(last);
                last--;
            }
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(',');
            }
            sb.delete(sb.length()-1, sb.length());
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] list = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(list[0]));
            queue.add(root);
            for (int i = 1; i < list.length; i+=2) {
                TreeNode t = queue.poll();
                if (!"null".equals(list[i])) {
                    t.left = new TreeNode(Integer.parseInt(list[i]));
                    queue.add(t.left);
                }
                if (i+1 < list.length && !"null".equals(list[i+1])) {
                    t.right = new TreeNode(Integer.parseInt(list[i+1]));
                    queue.add(t.right);
                }
            }
            return root;
        }
    }
}

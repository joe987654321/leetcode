package leetcode.joe;

import leetcode.treenode.TreeNode;

import java.util.*;

public class AAA {
    public static void main(String[] args) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        map.put(a1,1);

        System.out.println(map.get(a1));

        List<Integer> a2 = new LinkedList<>();
        a2.add(1);

        System.out.println(map.get(a2));

    }
}

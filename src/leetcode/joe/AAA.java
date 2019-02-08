package leetcode.joe;

import leetcode.treenode.TreeNode;

import java.util.*;

public class AAA {
    public static void main(String[] args) {
        Integer [] a = {6,5,4,2,1};
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " : " + Arrays.binarySearch(a, 0, 3, i, Comparator.reverseOrder()));
        }

        List<Integer> b = Arrays.asList(a);
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " : " + Collections.binarySearch(b, i));
        }
    }
}

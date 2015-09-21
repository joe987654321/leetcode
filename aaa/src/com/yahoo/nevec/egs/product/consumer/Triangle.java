package com.yahoo.nevec.egs.product.consumer;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            List<Integer> pre = new ArrayList<Integer>();
            List<Integer> next = new ArrayList<Integer>();


            pre.add(triangle.get(0).get(0));
            int height = triangle.size();
            for (int i=1; i<height; i++) {
                List<Integer> rowNow = triangle.get(i);
                for (int j=0; j<=i; j++) {
                    int min = rowNow.get(j);
                    if (j==0) {
                        min += pre.get(0);
                    } else if (j==i) {
                        min += pre.get(j-1);
                    } else {
                        min += Math.min(pre.get(j), pre.get(j-1));
                    }
                    next.add(min);
                }

                pre = next;
                next = new ArrayList<Integer>();
            }

            int min = Integer.MAX_VALUE;
         //   List<Integer> lastRow =  triangle.get(height-1);
            for (int i=0; i<height; i++) {
                min = Math.min(min, pre.get(i));
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> tree = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<Integer>() {{ add(2); }};
        List<Integer> row2 = new ArrayList<Integer>() {{ add(3); add(4); }};
        List<Integer> row3 = new ArrayList<Integer>() {{ add(6); add(5); add(7); }};
        List<Integer> row4 = new ArrayList<Integer>() {{ add(4); add(1); add(8); add(3); }};
        tree.add(row1);
        tree.add(row2);
        tree.add(row3);
        tree.add(row4);

        System.out.println(s.minimumTotal(tree));
    }
}

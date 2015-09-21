package com.yahoo.nevec.egs.product.consumer;

import java.util.Iterator;
import java.util.LinkedList;

public class UglyNumberII {
    public static class Solution {
        public int nthUglyNumber(int n) {
            if (n <= 1) {
                return n;
            }
            LinkedList<Integer> queue2 = new LinkedList<Integer>();
            LinkedList<Integer> queue3 = new LinkedList<Integer>();
            LinkedList<Integer> queue5 = new LinkedList<Integer>();
            queue2.add(1);
            int localMin = 0;
            for (int i=2;i<=n;i++) {
                localMin = Integer.MAX_VALUE;

                if (!queue2.isEmpty()) {
                    if (queue2.get(0) * 2 < localMin) {
                        localMin = queue2.get(0) * 2;

                    }
                }
                if (!queue3.isEmpty()) {
                    if (queue3.get(0) * 3 < localMin) {
                        localMin = queue3.get(0) * 3;

                    }
                }
                if (!queue5.isEmpty()) {
                    if (queue5.get(0) * 5 < localMin) {
                        localMin = queue5.get(0) * 5;

                    }
                }

                queue2.addLast(localMin);

                int tmp;
                if (!queue2.isEmpty()) {
                    if (queue2.get(0) * 2 == localMin) {
                        tmp = queue2.pop();
                        queue3.addLast(tmp);
                    }
                }
                if (!queue3.isEmpty()) {
                    if (queue3.get(0) * 3 == localMin) {
                        tmp = queue3.pop();
                        queue5.addLast(tmp);
                    }
                }
                if (!queue5.isEmpty()) {
                    if (queue5.get(0) * 5 == localMin) {
                        tmp = queue5.pop();
                    }
                }
            }
            return localMin;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nthUglyNumber(1));
        System.out.println(s.nthUglyNumber(2));
        System.out.println(s.nthUglyNumber(3));
        System.out.println(s.nthUglyNumber(4));
        System.out.println(s.nthUglyNumber(5));
        System.out.println(s.nthUglyNumber(6));
        System.out.println(s.nthUglyNumber(7));
        System.out.println(s.nthUglyNumber(8));
        System.out.println(s.nthUglyNumber(9));
        System.out.println(s.nthUglyNumber(10));
        System.out.println(s.nthUglyNumber(11));
        System.out.println(s.nthUglyNumber(12));
    }
}

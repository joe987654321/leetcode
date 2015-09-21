package com.yahoo.nevec.egs.product.consumer;

public class UniqueBinarySearchTrees {
    public static class Solution {
        public int numTrees(int n) {
            long r = 1;
            for (int i=1;i<=n;i++) {
                if (i<n) {
                    r*=2*n - i +1;
                }
                r/=i;
            }
            return (int)r;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(19));
    }


}

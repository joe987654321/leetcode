package com.yahoo.nevec.egs.product.consumer;

public class MyPow {
    public static class Solution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            if (x==1 || n == 0) {
                return 1;
            }

            if (x==-1) {
                if (n%2 == 0) {
                    return 1;
                } else {
                    return -1;
                }
            }

            int orig_n = n;
       //     ArrayList<Double> list = new ArrayList<Double>();
       //     ArrayList<Boolean> need = new ArrayList<Boolean>();

            n = Math.abs(n);

       //     list.add(x);
            double ret = 1;
            while (n!=1) {
                if (n%2 == 1) {
                    ret *= x;
                }
                n = n/2;
                x = x*x;
            }
            ret *= x;

            if (orig_n < 0) {
                ret = 1/ret;
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(-1, -222221));
    }
}

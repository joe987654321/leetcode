package com.yahoo.nevec.egs.product.consumer;

import java.util.ArrayList;

public class PermutationSequence {
    public static  class Solution {
        public String getPermutation(int n, int k) {
            ArrayList<Integer> numberList = new ArrayList<Integer>(n);
            int level = 1;
            for (int i = 1 ; i<=n ; i++) {
                numberList.add(i);
                level *= i;
            }
            StringBuilder sb = new StringBuilder("");
            k = k-1;
            while (n > 0) {
                level/=n;
                n--;
                System.out.println("k is " + k + " , level is " + level);
                int index = k/level;
                k = k%level;
                sb.append(numberList.get(index));
                numberList.remove(index);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(3, 6));


//        ArrayList<Integer> numberList = new ArrayList<Integer>(9);
//        for (int i = 0 ; i < 9 ; i++ ) {
//            numberList.add(i*10);
//        }
//        for (int i = 0 ; i < 9 ; i++ ) {
//            System.out.print(numberList.get(i)+" ");
//        }
//        System.out.println("#");
//
//
//        numberList.remove(5);
//        numberList.remove(3);
//        numberList.remove(1);
//        for (int i = 0 ; i < 6 ; i++ ) {
//            System.out.print(numberList.get(i) + " ");
//        }
//        System.out.println("#");
    }
}

package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateMaximumNumber {
    public static void main(String[] args) {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        int [] num1 = new int[] {};
        int [] num2 = new int[] {9,9,5,5,4,7};
//        int [] num1 = new int[] {3,4,6,5};
//        int [] num2 = new int[] {9,1,2,5,8,3};
        //int k = 2;
       // for (int i = 0; i <= num1.length +num2.length; i++) {
            int[] ints = createMaximumNumber.maxNumber(num1, num2, 4);
            System.out.println(Arrays.toString(ints));
        //}
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k<=0) return new int[0];
        int [] ret = new int[k];

        int min = Math.max(0, k-nums2.length);
        int max = Math.min(nums1.length, k);
        for (int i = min; i <= max; i++) {
            int [] num1 = fetch(nums1, i);
            int [] num2 = fetch(nums2, k-i);
            System.out.println(Arrays.toString(num1) + " & " +Arrays.toString(num2));

            int [] num3 = merge(num1, num2);
            System.out.println(Arrays.toString(num3));

            ret = intArrayMax(ret, num3);
        }
        return ret;
    }

    private int[] fetch (int [] num, int length) {
        if (length == 0) return new int[0];
        int minus = num.length - length;
        System.out.println("m is " + minus);
        int [] ret = new int[length];
        int idx = 0;
        for (int i = 0; i < num.length; i++) {
            while (minus != 0 && idx != 0 && ret[idx-1] < num[i]) {
                idx--;
                minus--;
            }
            if (idx != ret.length) {
                ret[idx++] = num[i];
            } else {
                minus--;
            }
        }
        return ret;
    }

    private int[] intArrayMax(int [] a1, int [] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] > a2[i]) return a1;
            else if (a1[i] < a2[i]) return a2;
        }
        return a1;
    }

    private int[] merge(int [] a1, int[] a2) {
        if (a1.length == 0) return a2;
        if (a2.length == 0) return a1;
        int [] ret = new int[a1.length +a2.length];
        int idx1=0, idx2=0, idx=0;
        while (idx1 <a1.length && idx2<a2.length) {
            if (greater(a1, idx1, a2, idx2)) ret[idx++] = a1[idx1++];
            else ret[idx++] = a2[idx2++];
        }
        while (idx1 <a1.length) ret[idx++] = a1[idx1++];
        while (idx2 <a2.length) ret[idx++] = a2[idx2++];
        return ret;
    }

    private boolean greater (int [] num1, int idx1, int [] num2, int idx2) {
        while (idx1 < num1.length && idx2 < num2.length && num1[idx1] == num2[idx2]) {
            idx1++;
            idx2++;
        }
        if (idx2 == num2.length) return true;
        if (idx1 == num1.length) return false;
        return num1[idx1] > num2[idx2];
    }
}

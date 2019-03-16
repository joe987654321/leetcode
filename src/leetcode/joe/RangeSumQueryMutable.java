package leetcode.joe;

import java.util.Arrays;

public class RangeSumQueryMutable {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(numArray.sumRange(1,5));
        System.out.println(numArray.sumRange(0,6));
        numArray.update(3, 10);
        System.out.println(numArray.sumRange(1,5));
        System.out.println(numArray.sumRange(0,6));
        System.out.println(numArray.sumRange(2,3));
    }

    public static class NumArray {

        int [] store;
        int length;

        //use segment tree
        public NumArray(int[] nums) {
            if (nums == null ||nums.length == 0) return;
            length = nums.length;
            store = new int[length*2];
            for (int i = length; i < length*2; i++) {
                store[i] = nums[i-nums.length];
            }
            for (int i = length-1; i >=0 ; i--) {
                store[i] = store[i*2] + store[i*2+1];
            }
            //System.out.println(Arrays.toString(store));
        }

        public void update(int i, int val) {
            int index = length + i;
            int diff = val - store[index];
            store[index] = val;
            while (index != 0) {
                store[index/2] += diff;
                index/=2;
            }
           // System.out.println(Arrays.toString(store));
        }

        public int sumRange(int i, int j) {
            i+=length;
            j+=length;
            //if (i == j) return store[i];
            int sum = 0;
            while (i < j) {
                if (i > (i^1)) sum += store[i++];
                if (j < (j^1)) sum += store[j--];
                i/=2;
                j/=2;
            }
            if (i == j) sum += store[i];
            return sum;
        }
    }
}

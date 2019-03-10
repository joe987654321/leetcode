package leetcode.joe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] ret = slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        System.out.println(Arrays.toString(ret));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        LinkedList<Integer> deque = new LinkedList<>();
        int [] ret = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.get(0) < i-k+1) deque.remove(0);
            while (!deque.isEmpty() && nums[deque.get(deque.size()-1)] <= nums[i]) deque.remove(deque.size()-1);
            deque.add(i);
            if (i >= k-1) {
                ret[i+1-k] = nums[deque.get(0)];
            }
        }
        return ret;
    }

}

package leetcode.practice200;

import java.util.HashSet;
import java.util.Set;

public class _128LongestConsecutiveSequence {
    public static void main(String[] args) {
        _128LongestConsecutiveSequence longestConsecutiveSequence = new _128LongestConsecutiveSequence();
        int i = longestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 3, 1, 2});
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null ||nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i: nums) set.add(i);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
                int high = nums[i]+1;
                int low = nums[i]-1;
                int len = 1;
                if (nums[i] != Integer.MAX_VALUE) {
                    while (set.contains(high)) {
                        set.remove(high);
                        len++;
                        if (high == Integer.MAX_VALUE) break;
                        high++;
                    }
                }
                if (nums[i] != Integer.MIN_VALUE) {
                    while (set.contains(low)) {
                        set.remove(low);
                        len++;
                        if (low == Integer.MIN_VALUE) break;
                        low--;
                    }
                }

                max = Math.max(max, len);
            }
        }
        return max;
    }

}

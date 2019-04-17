package leetcode.practice100;

import java.util.Arrays;

public class _075SortColors {
    public static void main(String[] args) {
        _075SortColors sortColors = new _075SortColors();
        int [] input = new int [] {2,0,1};
        sortColors.sortColors(input);
        System.out.println(Arrays.toString(input));
    }

    public void sortColors(int[] nums) {
        if (nums == null ||nums.length == 0) return;
        int start = 0;
        int end = nums.length-1;
        int now = 0;
        while (now <= end) {
            if (nums[now] == 0) {
                if (now != start) {
                    nums[now] = 1;
                    nums[start] = 0;
                }
                now++;
                start++;
            } else if (nums[now] == 1) {
                now++;
            } else { //2
                nums[now] = nums[end];
                nums[end] = 2;
                end--;
            }
        }
    }
}

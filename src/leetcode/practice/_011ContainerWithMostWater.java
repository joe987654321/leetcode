package leetcode.practice;

import java.util.Stack;

public class _011ContainerWithMostWater {
    public static void main(String[] args) {
        _011ContainerWithMostWater containerWithMostWater = new _011ContainerWithMostWater();
        int i = containerWithMostWater.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int nowLeft = left;
        int nowRight = right;
        int max = 0;
        while(nowLeft < nowRight) {
            if (height[left] < height[nowLeft]) {
                left = nowLeft;
            }
            if (height[right] < height[nowRight]) {
                right = nowRight;
            }
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                nowRight--;
            } else {
                nowLeft++;
            }
        }
        return max;
    }
}

package leetcode.practice;

import java.util.Stack;

public class _042TrappingRainWater {
    public static void main(String[] args) {
        _042TrappingRainWater trappingRainWater = new _042TrappingRainWater();
        int trap = trappingRainWater.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        System.out.println(trap);
    }

    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int nowMax = height[0];
        for (int i = 1; i < height.length; i++) {
            while (nowMax > height[stack.peek()] && height[i] > height[stack.peek()]) stack.pop();
            stack.push(i);
            nowMax = Math.max(nowMax, height[i]);
        }
        int total = 0;
        int right = stack.pop();
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int nowHeight = Math.min(height[left], height[right]);
            for (int i = left+1; i < right; i++) {
                total += nowHeight - height[i];
            }
            right = left;
        }
        return total;
    }
}

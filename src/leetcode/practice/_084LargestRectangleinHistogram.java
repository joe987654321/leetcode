package leetcode.practice;

import java.util.Stack;

public class _084LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] input = {0,0,0,2147483647};
        _084LargestRectangleinHistogram largestRectangleinHistogram = new _084LargestRectangleinHistogram();
        int max = largestRectangleinHistogram.largestRectangleArea(input);
        System.out.println(max);

    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> idxs = new Stack<>();
        int max = -1;
        for (int i = 0; i < heights.length; i++) {
            //if (!idxs.isEmpty() && heights[idxs.peek()] == heights[i]) continue;
            while (!idxs.isEmpty() && heights[idxs.peek()] > heights[i]) {
                int h = heights[idxs.pop()];
                int right = i - 1;
                int left = idxs.isEmpty() ? 0 : idxs.peek()+1;
                max = Math.max(max, h * (right - left + 1));
            }
            idxs.push(i);
        }
        while (!idxs.isEmpty()) {
            int h = heights[idxs.pop()];
            int right = heights.length-1;
            int left = idxs.isEmpty() ? 0 : idxs.peek()+1;
            max = Math.max(max, h * (right - left + 1));
        }
        return max;
    }
}

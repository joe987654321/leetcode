package leetcode.joe;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[stack.peek()] < heights[i]) {
                stack.add(i);
            } else {
                //reach right boundary of index on top of stack, count the max area it can have
                int choiceIndex = stack.pop();
                int heightOnIndex = heights[choiceIndex];
                int leftBoundary = stack.empty() ? -1: stack.peek();
                max = Math.max(max, heightOnIndex * (i-leftBoundary-1));
                i--;
            }
        }

        while (!stack.empty()) {
            int choiceIndex = stack.pop();
            int heightOnIndex = heights[choiceIndex];
            int leftBoundary = stack.empty() ? -1: stack.peek();
            max = Math.max(max, heightOnIndex * (heights.length-leftBoundary-1));
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();

        int [] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleInHistogram.largestRectangleArea(a));

    }
}

package leetcode.practice;

import java.util.Stack;

public class _032LongestValidParentheses {
    public static void main(String[] args) {
        _032LongestValidParentheses longestValidParentheses = new _032LongestValidParentheses();
        int ret = longestValidParentheses.longestValidParentheses("())(()())");
        System.out.println(ret);
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int block = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    block = i;
                    continue;
                }
                stack.pop();
                max = Math.max(max, stack.isEmpty() ? i-block : i-stack.peek());
            }
        }
        return max;
    }
}

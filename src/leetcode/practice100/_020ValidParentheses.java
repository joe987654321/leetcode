package leetcode.practice100;

import java.util.Stack;

public class _020ValidParentheses {
    public static void main(String[] args) {
        _020ValidParentheses validParentheses = new _020ValidParentheses();
        boolean valid = validParentheses.isValid("{}[()]");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                char t = '('; // c == ')'
                if (c == ']') t = '[';
                else if (c == '}') t = '{';
                if (stack.isEmpty() || stack.pop() != t) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

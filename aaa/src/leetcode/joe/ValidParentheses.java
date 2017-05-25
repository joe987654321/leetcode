package leetcode.joe;

import java.util.Stack;

/**
 * Created by joe321 on 2017/5/24.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
       // int [] counts = new int [3];
        Stack<Integer> stack = new Stack<>();
        for (char c :s.toCharArray()) {
            if (c=='(') {
                //counts[0]++;
                stack.add(0);
            }
            if (c=='[') {
                //counts[1]++;
                stack.add(1);
            }
            if (c=='{') {
                //counts[2]++;
                stack.add(2);
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (c==')') {
                //counts[0]--;
                int top = stack.pop();
                if (top != 0) {
                    return false;
                }
            }
            if (c==']') {
                int top = stack.pop();
                if (top != 1) {
                    return false;
                }
            }
            if (c=='}') {
                int top = stack.pop();
                if (top != 2) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{[][]}()"));
    }
}

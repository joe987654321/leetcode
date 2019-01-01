package leetcode.joe;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        int e = evaluateReversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(e);
    }

    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();

        Set<String> ops = new HashSet<String>() {{add("+"); add("-"); add("*"); add("/");}};
        for (int i = 0; i < tokens.length; i++) {
            if (!ops.contains(tokens[i])) {
                stack.push(Long.parseLong(tokens[i]));
            } else {
                long second = stack.pop();
                long first = stack.pop();
                switch(tokens[i]) {
                case "+":
                    stack.push(first + second);
                    break;
                case "-":
                    stack.push(first - second);
                    break;
                case "*":
                    stack.push(first * second);
                    break;
                case "/":
                    stack.push(first / second);
                    break;
                }
            }
        }
        return stack.pop().intValue();
    }
}

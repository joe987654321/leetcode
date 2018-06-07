package leetcode.joe;



import javafx.util.Pair;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();

        String s = "2 - (1-3)";
        int c = basicCalculator.calculate(s);
        System.out.println(c);
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackOp = new Stack<>();

        int index = 0;
        int pre = 0;
        int op = 1; //1: +, -1: -
        StringBuilder sb = new StringBuilder("0");
        for (;index != s.length();index++) {
            char t = s.charAt(index);
            if (t >= '0' && t <= '9') {
                sb.append(t);
            } else if (t == ' ') {
                continue;
            } else {
                int tmp = Integer.parseInt(sb.toString());
                pre += op*tmp;
                sb = new StringBuilder("0");
                if (t == '+') {
                    op = 1;
                } else if (t == '-') {
                    op = -1;
                } else if (t == '(') {
                    stack.push(pre);
                    stackOp.push(op);
                    pre = 0;
                    op = 1;
                } else {
                    int preStack = stack.pop();
                    int opStack = stackOp.pop();
                    pre = preStack + opStack*pre;
                    op = 1;
                }
            }
        }
        int tmp = Integer.parseInt(sb.toString());
        pre += op*tmp;
        return pre;
    }
}

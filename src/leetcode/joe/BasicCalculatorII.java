package leetcode.joe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BasicCalculatorII {
    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        int calculate = basicCalculatorII.calculate(" 3  + 2 0 *2    /5 - 3 + 5 /2");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        List<Long> num = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                num.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                combineLast(num, ops);
                ops.add(c);

//                System.out.println(num);
//                System.out.println(ops);

            } else {
                sb.append(c);
            }
        }

        num.add(Long.parseLong(sb.toString()));
        combineLast(num, ops);

        long ret = num.get(0);
        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i) == '+') ret += num.get(i+1);
            if (ops.get(i) == '-') ret -= num.get(i+1);
        }
        return (int)ret;
    }

    private void combineLast(List<Long> num, List<Character> ops) {
        if (!ops.isEmpty()) {
            if (ops.get(ops.size() - 1) == '*') {
                long tmp = num.get(num.size() - 2) * num.get(num.size() - 1);
                num.set(num.size() - 2, tmp);
                num.remove(num.size() - 1);
                ops.remove(ops.size() - 1);
            } else if (ops.get(ops.size() - 1) == '/') {
                long tmp = num.get(num.size() - 2) / num.get(num.size() - 1);
                num.set(num.size() - 2, tmp);
                num.remove(num.size() - 1);
                ops.remove(ops.size() - 1);
            }
        }
    }
}

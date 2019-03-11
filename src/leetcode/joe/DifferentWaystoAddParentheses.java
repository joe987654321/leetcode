package leetcode.joe;

import sun.util.resources.cldr.da.CalendarData_da_DK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public static void main(String[] args) {
        DifferentWaystoAddParentheses differentWaystoAddParentheses = new DifferentWaystoAddParentheses();
        List<Integer> integers = differentWaystoAddParentheses.diffWaysToCompute("2*3-4*5*10");
        System.out.println(integers);
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        if (input == null || input.length() == 0) return ret;
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (sb.length() != 0 && ((c == '+' || c == '-' || c == '*'))) {
                nums.add(Integer.parseInt(sb.toString()));
                ops.add(c);
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        nums.add(Integer.parseInt(sb.toString()));
        ret = _diffWaysToCompute(nums, ops);
        Collections.sort(ret);
        return ret;
    }

    private List<Integer> _diffWaysToCompute(List<Integer> nums, List<Character> ops) {
        List<Integer> ret = new ArrayList<>();
        if (ops.size() == 0) {
            ret.add(nums.get(0));
            return ret;
        }
        for (int i = 0; i < ops.size(); i++) {
            List<Integer> left = _diffWaysToCompute(nums.subList(0, i+1), ops.subList(0, i));
            List<Integer> right = _diffWaysToCompute(nums.subList(i+1, nums.size()), ops.subList(i+1, ops.size()));
            for (Integer m: left) {
                for (Integer n: right) {
                    if (ops.get(i) == '+') ret.add(m + n);
                    if (ops.get(i) == '-') ret.add(m - n);
                    if (ops.get(i) == '*') ret.add(m * n);
                }
            }
        }
        return ret;
    }
}

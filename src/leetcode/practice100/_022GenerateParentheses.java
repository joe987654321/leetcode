package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

public class _022GenerateParentheses {
    public static void main(String[] args) {
        _022GenerateParentheses generateParentheses = new _022GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }
        _generate(ret, new StringBuilder(), 0, n);
        return ret;
    }

    private void _generate(List<String> ret, StringBuilder sb, int nowLeft, int count) {
        if (count == 0 && nowLeft == 0) {
            ret.add(sb.toString());
            return;
        }
        if (count > 0) {
            sb.append('(');
            _generate(ret, sb, nowLeft+1, count-1);
            sb.deleteCharAt(sb.length()-1);
        }
        if (nowLeft > 0) {
            sb.append(')');
            _generate(ret, sb, nowLeft-1, count);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

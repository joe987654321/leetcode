package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2017/5/26.
 */
public class GenerateParentheses {

    public void recursiveGenerateParenthesis(List<String> list, int n, int left, int right, String nowPattern) {
        if (left == n && right == n) {
            list.add(nowPattern);
            return;
        }
        if (left < n) {
            recursiveGenerateParenthesis(list, n, left + 1, right, nowPattern + '(');
        }
        if (right < left && right < n) {
            recursiveGenerateParenthesis(list, n, left, right +1, nowPattern + ')');
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursiveGenerateParenthesis(list, n, 0, 0, "");
        return list;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}

package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();

        List<String> stringList = removeInvalidParentheses.removeInvalidParentheses("(a(b())c))(()");
        System.out.println(stringList);

    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null) return ret;
        _find(ret, new StringBuilder(s), '(', ')', 0, 0);
        return ret;
    }

    private void _find(List<String> ret, StringBuilder sb, char lb, char rb, int start, int deleteFrom) {
        int count = 0;
        for (int i = start; i < sb.length(); i++) {
            if (sb.charAt(i) == lb) count++;
            if (sb.charAt(i) == rb) {
                count--;
                if (count < 0) {
                    for (int j = deleteFrom; j <= i; j++) {
                        if (sb.charAt(j) == rb) {
                            if (j == deleteFrom || sb.charAt(j-1) != rb) {

                                sb.deleteCharAt(j);
                                //System.out.println(start + " :" +  j + "in loop 1" + sb);
                                _find(ret, sb, lb, rb, start, j);
                               // System.out.println(start + " :" +  j + "in loop 2" + sb);
                                sb.insert(j, rb);

                            }
                        }
                    }
                    return;
                }
            }
        }

        if (count == 0) {
            if (lb == '(') {
                ret.add(sb.toString());
            } else {
                ret.add(sb.reverse().toString());
                sb.reverse();
            }
        } else if (lb == '(') {
            _find(ret, sb.reverse(), ')', '(', 0, 0);
            sb.reverse();
        }
    }

}

package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

public class _017LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        _017LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new _017LetterCombinationsOfAPhoneNumber();
        List<String> strings = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        System.out.println(strings);

    }

    private static String[] tokens = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        _letterCombinations(ret, new StringBuilder(), digits, 0);
        return ret;
    }

    private void _letterCombinations(List<String> ret, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        char num = digits.charAt(index);
        for (int i = 0; i < tokens[num-'0'].length(); i++) {
            sb.append(tokens[num-'0'].charAt(i));
            _letterCombinations(ret, sb, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

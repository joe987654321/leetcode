package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2017/4/18.
 */
public class LetterCombinationsOfAPhoneNumber {
    private final char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    private void addAllCombinations(String digits, int index, String prefix, List<String> ret) {
        if (index == digits.length()) {
            ret.add(prefix);
            return;
        }

        char [] charList = map[digits.charAt(index)-'0'];

        for (int i = 0; i < charList.length; i++) {
            addAllCombinations(digits, index + 1, prefix + charList[i], ret);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        for (int i = 0; i < digits.length(); i++) {
            if (!(2 <= digits.charAt(i) && digits.charAt(i) <= '9')) {
                return ret;
            }
        }
        addAllCombinations(digits, 0, "", ret);

        return ret;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("2340"));
    }
}

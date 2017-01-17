package leetcode.joe;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by joe321 on 2017/1/17.
 */
public class ReverseWordsInAString {
    private void reverse(char [] chars, int beginIndex, int endIndex) {
        char tmp;
        int head = beginIndex;
        int tail = endIndex;
        while (tail > head) {
            tmp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = tmp;
            tail--;
            head++;
        }
    }

    public String reverseWords(String s) {
        char [] chars = new char[s.length()];
        boolean stringStart = false;
        boolean inMiddleOfSpace = false;
        int index = 0;
        for (char c: s.toCharArray()) {
            if (c != ' ') {
                stringStart = true;
                inMiddleOfSpace = false;
                chars[index] = c;
                index++;
            } else {
                if (stringStart && !inMiddleOfSpace) {
                    inMiddleOfSpace = true;
                    chars[index] = ' ';
                    index++;
                }
            }
        }

        System.out.println(chars);

        if (!stringStart) {
            return "";
        }

        int globalEndIndex = index -1;
        if (inMiddleOfSpace) {
            globalEndIndex--;
        }

        reverse(chars, 0, globalEndIndex);

        System.out.println(chars);

        for (int i = 0; i < globalEndIndex + 1; i++) {
            if (chars[i] != ' ') {
                int beginIndex = i;
                int endIndex;
                for (endIndex = i; endIndex < globalEndIndex+1; endIndex++) {
                    if (chars[endIndex] == ' ') {
                        endIndex = endIndex -1;
                        break;
                    }
                }
                if (endIndex == globalEndIndex+1) {
                    endIndex = globalEndIndex;
                }
                reverse(chars, beginIndex, endIndex);
                i = endIndex;
            }
        }

        String ss = new String(chars, 0, globalEndIndex + 1);
        return ss;
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String s = "   this   is blue sky   ";
        System.out.println(reverseWordsInAString.reverseWords(s));
    }
}

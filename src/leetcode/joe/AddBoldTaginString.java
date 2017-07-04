package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/6/11.
 */
public class AddBoldTaginString {

    public String addBoldTag(String s, String[] dict) {
        boolean[] exist = new boolean[s.length()];
        for (int i = 0; i < dict.length; i++) {
            int indexFrom = 0;
            int startIndex = s.indexOf(dict[i], indexFrom);
            while (startIndex != -1) {
                for (int j = 0; j < dict[i].length(); j++) {
                    exist[startIndex+j] = true;
                }
                indexFrom = startIndex + dict[i].length();
                startIndex = s.indexOf(dict[i], indexFrom);
            }
        }
        boolean startBold = false;
        StringBuilder ret = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (exist[i] && !startBold) {
                ret.append("<b>");
                startBold = true;
            } else if (startBold && !exist[i]) {
                ret.append("</b>");
                startBold = false;
            }
            ret.append(s.charAt(i));
        }
        if (startBold) {
            ret.append("</b>");
        }

        //System.out.println(Arrays.toString(exist));

        return ret.toString();
    }

    public static void main(String[] args) {
        AddBoldTaginString addBoldTaginString = new AddBoldTaginString();
        String s = "aaabbcc";
        String[] dict = {"aaa","aab","bc"};
        System.out.println(addBoldTaginString.addBoldTag(s, dict));
    }
}

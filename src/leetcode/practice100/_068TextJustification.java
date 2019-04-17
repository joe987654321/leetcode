package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

public class _068TextJustification {
    public static void main(String[] args) {
        _068TextJustification textJustification = new _068TextJustification();
        String [] ss = new String[] {"The","important","thing","is","not","to","stop","questioning.","Curiosity","has","its","own","reason","for","existing."
        };
        List<String> ret = textJustification.fullJustify(ss, 17);
        System.out.println(ret);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int nowCount = 0;
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (nowCount == 0) {
                tmp.add(words[i]);
                nowCount = words[i].length();
            } else {
                if (nowCount + 1 + words[i].length() <= maxWidth) {
                    tmp.add(words[i]);
                    nowCount += 1 + words[i].length();
                } else {
                    ret.add(toOurString(tmp, maxWidth, false));
                    tmp.clear();

                    tmp.add(words[i]);
                    nowCount = words[i].length();
                }
            }
        }
        if (nowCount != 0) {
            ret.add(toOurString(tmp, maxWidth, true));
        }
        return ret;
    }

    private String toOurString(List<String> tmp, int maxWidth, boolean leftJustified) {
        StringBuilder sb = new StringBuilder();

        if (leftJustified) {
            sb.append(tmp.get(0));
            for (int i = 1; i < tmp.size(); i++) {
                sb.append(' ').append(tmp.get(i));
            }
            while (sb.length() != maxWidth) sb.append(' ');
            return sb.toString();
        }

        if (tmp.size() == 1) {
            sb.append(tmp.get(0));
            while (sb.length() != maxWidth) sb.append(' ');
            return sb.toString();
        }

        int spaceCount = maxWidth;
        for (String s1 : tmp) {
            spaceCount -= s1.length();
        }

        int spaceEach = spaceCount/(tmp.size()-1);
        int left = spaceCount - (spaceEach * (tmp.size()-1));

        for (String s : tmp) {
            if (sb.length() == 0) {
                sb.append(s);
            } else {
                for (int j = 0; j < spaceEach; j++) sb.append(' ');
                if (left > 0) {
                    sb.append(' ');
                    left--;
                }
                sb.append(s);
            }
        }
        return sb.toString();
    }
}

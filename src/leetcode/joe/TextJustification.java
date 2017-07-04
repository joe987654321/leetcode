package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2017/6/26.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        if (maxWidth == 0) {
            ret.add("");
            return ret;
        }
        if (words.length == 0) {
            String tmp = new String(new char[maxWidth]).replace('\0',' ');
            ret.add(tmp);
            return ret;
        }

        List<Integer> groups = new ArrayList<>();
        int nowContainWords = 0;
        int nowLength = 0;
        for (int i = 0; i < words.length; i++) {
            if (nowContainWords != 0) {
                nowLength++;
            }

            if (nowLength + words[i].length() <= maxWidth) {
                nowLength += words[i].length();
                nowContainWords++;
            } else {
                groups.add(nowContainWords);
                nowContainWords = 1;
                nowLength = words[i].length();
            }
        }
        groups.add(nowContainWords);
        int startIndex = 0;
        for (int i = 0; i < groups.size()-1; i++) {
            int count = groups.get(i);
            if (count==1) {
                StringBuilder sb = new StringBuilder(words[startIndex]);
                int spaceCount = maxWidth - words[startIndex].length();
                for (int j = 0; j < spaceCount; j++) {
                    sb.append(' ');
                }
                ret.add(sb.toString());
                startIndex++;
                continue;
            }

            nowLength = 0;
            for (int j = 0; j < count; j++) {
                nowLength += words[startIndex+j].length();
            }

            int spaceCount = (maxWidth - nowLength) / (count-1);
            int hasMoreSpaceCount = (maxWidth - nowLength) % (count-1);

            StringBuilder sb = new StringBuilder(words[startIndex]);
            for (int j = 1; j < count; j++) {
                for (int k = 0; k < spaceCount; k++) {
                    sb.append(' ');
                }
                if (j <= hasMoreSpaceCount) {
                    sb.append(' ');
                }
                sb.append(words[startIndex+j]);
            }
            ret.add(sb.toString());
            startIndex+=count;
        }

        int count = groups.get(groups.size()-1);
        StringBuilder sb = new StringBuilder(words[startIndex]);
        for (int j = 1; j < count; j++) {
            sb.append(' ');
            sb.append(words[startIndex+j]);
        }
        int spaceCount = maxWidth - sb.length();
        for (int i = 0; i < spaceCount; i++) {
            sb.append(' ');
        }
        ret.add(sb.toString());

        return ret;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int L = 16;
        TextJustification textJustification = new TextJustification();
        System.out.println(textJustification.fullJustify(words, L));
    }
}

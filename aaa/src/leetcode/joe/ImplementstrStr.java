package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/5/31.
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }
        int [] failure = new int [needle.length()];
        int nowMatchLength = failure[0] = -1;
        for (int i = 1; i < needle.length(); i++) {

            while(nowMatchLength != -1 && needle.charAt(nowMatchLength+1) != needle.charAt(i)) {
                nowMatchLength = failure[nowMatchLength];
            }

            if (needle.charAt(nowMatchLength+1) == needle.charAt(i)) {
                nowMatchLength++;
            }

            failure[i] = nowMatchLength;
        }

     //   System.out.println(Arrays.toString(failure));

        int needleIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
          //  System.out.println("try " + i + ":" +haystack.charAt(i) + " and " + needleIndex + ":" + needle.charAt(needleIndex));
            if (haystack.charAt(i) == needle.charAt(needleIndex)) {
                needleIndex++;
                if (needleIndex == needle.length()) {
                    return i-needle.length()+1;
                }
            } else {
               // System.out.println("fail at " + needleIndex + ":" + failure[needleIndex-1]);
                while (needleIndex != 0) {
                    needleIndex = failure[needleIndex-1] + 1;
                    if (haystack.charAt(i) == needle.charAt(needleIndex)) {
                        needleIndex++;
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr implementstrStr = new ImplementstrStr();
        String s = "aaaaaaaaaaaaaaaaaab";
        String t = "aaaaaaaax";
        System.out.println(implementstrStr.strStr(s,t));
    }
}

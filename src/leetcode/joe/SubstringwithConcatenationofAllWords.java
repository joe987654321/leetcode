package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joe321 on 2017/6/7.
 */
public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return null;
        }
        int wLength = words[0].length();

        Map<String, Integer> wordToOccur = new HashMap<>();
        for (String word: words) {
            Integer pre = wordToOccur.get(word);
            if (pre == null) {
                pre = 0;
            }
            wordToOccur.put(word, pre + 1);
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < wLength; i++) {
            if ((s.length()-i)/wLength == 0) {
                return ret;
            }
            String [] stringSegments = new String[(s.length()-i)/wLength];
            for (int j = 0; j < stringSegments.length; j++) {
             //   System.out.println(j * wLength + i);
                stringSegments[j] = s.substring( j * wLength + i, (j+1) * wLength + i);
            }
            System.out.println(Arrays.toString(stringSegments));

            int startSegmentIndex = -1;
            for (int j = 0; j < stringSegments.length; j++) {
                Integer left = wordToOccur.get(stringSegments[j]);
                if (left != null && left > 0) {
                    wordToOccur.put(stringSegments[j], left -1);
                } else if (left == null) {
                    //recover to index j
                    startSegmentIndex++;
                    while(startSegmentIndex != j) {
                    //    System.out.println("check " + stringSegments[startSegmentIndex]);
                        Integer tmp = wordToOccur.get(stringSegments[startSegmentIndex]);
                        if (wordToOccur.get(stringSegments[startSegmentIndex]) != null) {
                            wordToOccur.put(stringSegments[startSegmentIndex], tmp + 1);
                            //System.out.println("recover " + stringSegments[startSegmentIndex]);
                        }
                        startSegmentIndex++;
                    }
                } else {
                    //recover to the index k which stringSegments[k] == stringSegments [j]
                    startSegmentIndex++;
                    while(!stringSegments[startSegmentIndex].equals(stringSegments[j])) {
                        //System.out.println(stringSegments[startSegmentIndex] + "::" + stringSegments[j]);
                        Integer tmp = wordToOccur.get(stringSegments[startSegmentIndex]);
                        if (wordToOccur.get(stringSegments[startSegmentIndex]) != null) {
                            wordToOccur.put(stringSegments[startSegmentIndex], tmp + 1);
                            System.out.println("recover " + stringSegments[startSegmentIndex]);
                        }
                        startSegmentIndex++;
                    }
                    //now stringSegments[startSegmentIndex] == stringSegments[j]
                }

                System.out.println("startSegmentIndex:j = " + startSegmentIndex + ":" + j);
                System.out.println(wordToOccur);
                if (j - startSegmentIndex == words.length) {
                    ret.add((startSegmentIndex+1)*wLength + i);
                    //recover one step
                    startSegmentIndex++;
                    Integer tmp = wordToOccur.get(stringSegments[startSegmentIndex]);
                    wordToOccur.put(stringSegments[startSegmentIndex], tmp + 1);
                }

            }
            //recover to stringSegments.length-1
            startSegmentIndex++;
            while (startSegmentIndex <= stringSegments.length-1) {
                Integer tmp = wordToOccur.get(stringSegments[startSegmentIndex]);
                if (wordToOccur.get(stringSegments[startSegmentIndex]) != null) {
                    wordToOccur.put(stringSegments[startSegmentIndex], tmp + 1);
                    //System.out.println("recover " + stringSegments[startSegmentIndex]);
                }
                startSegmentIndex++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();
        String s = "barfoothefoobarman";
        String [] words = {"foo", "bar"};
        System.out.println(substringwithConcatenationofAllWords.findSubstring(s, words));

    }
}

package leetcode.joe;

import java.util.Arrays;
import java.util.Random;

public class MaximumProductofWordLengths {

    public static int maxProduct(String[] words) {
        if (words == null) {
            return 0;
        }
        int max = 0;
        int length = words.length;
        int [] mapping  = new int[length];
        for (int i = 0; i<length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mapping[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }

        for (int i = 0; i<length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((mapping[i] & mapping[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String [] input = {"a", "aa", "aaa", "aaaa"};
        System.out.println(maxProduct(input));
        System.out.println(new Random().nextInt(2));
        int [] aaa = {1,2,3};
        int [] bbb = Arrays.copyOf(aaa,3);
    }

}

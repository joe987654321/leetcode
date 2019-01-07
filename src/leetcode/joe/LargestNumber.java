package leetcode.joe;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        String s = largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        String [] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (s[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }
}

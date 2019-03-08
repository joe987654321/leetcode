package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        List<String> strings = summaryRanges.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        System.out.println(strings);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) end++;
            else {
                if (start == end) ret.add("" + start);
                else ret.add("" + start + "->" + end);
                start = end = nums[i];
            }
        }
        if (start == end) ret.add("" + start);
        else ret.add("" + start + "->" + end);

        return ret;
    }
}

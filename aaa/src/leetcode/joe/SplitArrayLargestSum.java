package leetcode.joe;

/**
 * Created by joe321 on 2017/1/10.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long max = 0;
        long min = Integer.MAX_VALUE;
        for (int num : nums) {
            max += num;
            if (num < min) {
                min = num;
            }
        }

        int ans = Integer.MAX_VALUE;
        while (max > min) {
            System.out.println(min + " " + max);

            long mid = (max + min) / 2;
            int groupCount = 1;
            int now = 0;
            for (int num: nums) {
                if (num > mid) {
                    //not possible
                    groupCount = Integer.MAX_VALUE;
                    break;
                }
                if (now + num > mid) {
                    now = num;
                    groupCount++;
                    if (groupCount > m) {
                        break;
                    }
                } else {
                    now += num;
                }
            }

            if (groupCount > m) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }
        return (int) max;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();

        int [] nums = {1,2147483647};
        int m = 2;
        System.out.println(splitArrayLargestSum.splitArray(nums, m));


    }
}

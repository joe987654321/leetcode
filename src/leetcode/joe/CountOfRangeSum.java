package leetcode.joe;

import java.util.Map;
import java.util.TreeMap;

public class CountOfRangeSum {
    public static void main(String[] args) {
        CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
        int[] input = new int[] {-2,5,-1};
        int lower = -2, upper = 2;
        int i = countOfRangeSum.countRangeSum(input, lower, upper);
        System.out.println(i);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) return 0;
        long [] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i-1]+nums[i];
        return _countRangeSum(sums, 0, sums.length-1, lower, upper);
    }

    private int _countRangeSum(long[] sums, int start, int end, int lower, int upper) {
        //if (start > end) return 0;
        if (start == end) return (sums[start] <= upper && sums[end] >= lower) ? 1 : 0;
        int mid = start + (end-start)/2;
        int count = _countRangeSum(sums, start, mid, lower, upper)
                + _countRangeSum(sums, mid+1, end, lower, upper);
        long [] tmp = new long[end-start+1];
        int idx1;

        int x = mid+1, y = mid+1;
        for (idx1=start; idx1 <= mid; idx1++) {
            while (x <= end && sums[x] - sums[idx1] < lower) x++;
            while (y <= end && sums[y] - sums[idx1] <= upper) y++;
            count += y-x;
        }

        int idx, idx2 = mid+1;
        for (idx = 0, idx1=start; idx1 <= mid; idx++, idx1++) {
            while (idx2 <= end && sums[idx2] <= sums[idx1]) tmp[idx++] = sums[idx2++];
            tmp[idx] = sums[idx1];
        }
        while (idx2 <= end) tmp[idx++] = sums[idx2++];
        System.arraycopy(tmp, 0, sums, start, tmp.length);
        return count;
    }

    public int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) return 0;
         
        TreeMap<Long, Integer> sumToCount = new TreeMap<>();
        long sum = 0;
        int total = 0;
        sumToCount.put(0L, 1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            Map<Long, Integer> map = sumToCount.subMap(sum - upper, true, sum - lower, true);
            for (Integer tmp: map.values()) {
                total+=tmp;
            }
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) +1);
        }
        return total;
    }
}

package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joe on 2017/5/21.
 */
public class Harmonious {
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> value = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        int now = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (c == 0) {
                now = nums[i];
                c++;
                continue;
            }
            if (nums[i] == now) {
                c++;
            } else {
                value.add(now);
                count.add(c);
                now = nums[i];
                c = 1;
            }
        }
        if (c != 0) {
            value.add(now);
            count.add(c);
        }

        int pre = value.get(0);
        int max = 0;
        for (int i = 1; i < value.size(); i++) {
            if (value.get(i) == pre +1) {
                max = Math.max(max, count.get(i-1) + count.get(i));
            }
            pre = value.get(i);
        }

        return max;
    }

    public int findLHS2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int localMax = 1;
            boolean notAllSame = false;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] - nums[i] == 1 || nums[j] == nums[i]) {
                    localMax++;
                    if (nums[j] - nums[i] == 1) {
                        notAllSame = true;
                    }
                }
                if (notAllSame) {
                    max = Math.max(localMax, max);
                }
            }
            localMax = 1;
            notAllSame = false;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] - nums[i] == -1 || nums[j] == nums[i]) {
                    localMax++;
                    if (nums[j] - nums[i] == -1) {
                        notAllSame = true;
                    }
                }
                if (notAllSame) {
                    max = Math.max(localMax, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Harmonious harmonious = new Harmonious();
        int [] a = {1,3,2,2,5,2,3,7};
        int [] b = {1,1,1,1};
        System.out.println(harmonious.findLHS(b));
    }
}

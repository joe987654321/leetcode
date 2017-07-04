package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2017/4/19.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);

        Integer [] pre = null;
        Integer prei = null, prej = null;
        for (int i = 0; i < nums.length; i++) {
            prej = null;
            if (prei != null && nums[i] == prei) {
           //     System.out.println("prei " + prei);
                continue;
            }
            prei = nums[i];
            for (int j = i + 1 ; j < nums.length; j++) {
                if (prej != null && nums[j] == prej) {
               //     System.out.println("prej " + prej);
                    continue;
                }
                prej = nums[j];

                int nowTarget = target - nums[i] - nums[j];
                int head = j+1;
                int tail = nums.length - 1;
                while (tail > head) {
                    if (nums[tail] + nums[head] == nowTarget) {
                        Integer [] tmp = {nums[i], nums[j], nums[head], nums[tail]};
                        //if (pre == null || !(tmp[0] <= pre[0] && tmp[1] <= pre[1] && tmp[2] <= pre[2] && tmp[3] <= pre[3])) {
                        if (!Arrays.equals(tmp, pre)) {
                            ret.add(Arrays.asList(tmp));
                            pre = tmp;
                        }
                       // System.out.println("add index: " + i + j + head + tail);
                        head ++;
                    } else if (nums[tail] + nums[head] < nowTarget) {
                        head++;
                    } else {
                        tail--;
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        FourSum fourSum = new FourSum();
//        int [] a = {1, 0, -1, 0, -2, 2};
//        int [] b = {1,1,1,1,1};
        int [] c = {-7,-5,0,7,1,1,-10,-2,7,7,-2,-6,0,-10,-5,7,-8,5};
        //int [] d = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
//        System.out.println(fourSum.fourSum(a, 0));
//        System.out.println(fourSum.fourSum(b, 4));
        System.out.println(fourSum.fourSum(c, 28));
        //System.out.println(fourSum.fourSum(d, 0));
    }
}

package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> ret = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (k == 0 || length1 == 0 || length2 == 0) {
            return ret;
        }

        int [] num2Index = new int[length1];

        for (int kk=0; kk<k; kk++) {
            int min = Integer.MAX_VALUE;
            int election1 = 0, election2 = 0;
           // int prevNum2Index = Integer.MAX_VALUE;
            for (int i = 0; i < length1; i++) {
                if (num2Index[i] >= length2) {
                    continue;
                }

                if (min > nums1[i] + nums2[num2Index[i]]) {
                    election1 = i;
                    election2 = num2Index[i];
                    min = nums1[i] + nums2[num2Index[i]];
                }

                if (num2Index[i] == 0) {
                    break;
                }
            }

            if (min == Integer.MAX_VALUE) {
                //end
                break;
            }

//            System.out.println("min is " + min);
//            System.out.println(election1 + "," + election2);
            num2Index[election1]++;

            int [] tmp = {nums1[election1], nums2[election2]};
            ret.add(tmp);
        }

        return ret;
    }

    public static void main(String[] args) {
        FindKPairswithSmallestSums f = new FindKPairswithSmallestSums();
        int [] a = {1,1,2};
        int [] b = {1,2};
        int k = 3;

        for (int [] tmp: f.kSmallestPairs(a, b, 10)) {
            System.out.print("[");
            for (int i: tmp) {
                System.out.print(i + ",");
            }
            System.out.println("],");
        }

    }

}

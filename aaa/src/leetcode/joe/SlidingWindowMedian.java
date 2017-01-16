package leetcode.joe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by joe321 on 2017/1/16.
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double [] ret = new double[nums.length - k + 1];

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        Comparator<Integer> comp2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        };

        PriorityQueue<Integer> minq = new PriorityQueue<>(comp);
        PriorityQueue<Integer> maxq = new PriorityQueue<>(comp2);

        int [] tmp = Arrays.copyOf(nums, k);

        Arrays.sort(tmp);
        for (int i = 0; i < k/2; i++) {
            minq.add(tmp[i]);
        }
        for (int i = k/2; i < k; i++) {
            maxq.add(tmp[i]);
        }

//        System.out.println(minq);
//        System.out.println(maxq);

        ret[0] = getMedium(minq, maxq);

        for (int i = 0; i < nums.length - k; i++) {

            //-2: add maxq remove minq
            //0:  add maxq remove maxq OR add minq remove minq OR
            //2:  add minq remove maxq
            int shift = 0;

//            System.out.println("remove: " + nums[i] + ", add: " + nums[k+i]);

            if (nums[i] < ret[i]) {
                minq.remove(nums[i]);
                shift--;
            } else {
                maxq.remove(nums[i]);
                shift++;
            }

            if (nums[k+i] < ret[i]) {
                minq.add(nums[k+i]);
                shift++;
            } else {
                maxq.add(nums[k+i]);
                shift--;
            }

            if (shift == 0) {
                ret[i+1] = getMedium(minq, maxq);
            } else if (shift == -2) {
                minq.add(maxq.remove());
                ret[i+1] = getMedium(minq, maxq);
            } else {
                maxq.add(minq.remove());
                ret[i+1] = getMedium(minq, maxq);
            }

//            System.out.println("NOW: " + minq + maxq);
        }

        return ret;
    }

    private double getMedium(PriorityQueue<Integer> minq, PriorityQueue<Integer> maxq) {
        if (minq.size() == maxq.size()) {
            double tmp = minq.peek();
            double tmp2 = maxq.peek();
            return (tmp + tmp2)/2;
        } else {
            return maxq.peek();
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        int [] nums = {2147483647,2147483647};
        int k = 2;
        double [] d  = slidingWindowMedian.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(d));
    }
}

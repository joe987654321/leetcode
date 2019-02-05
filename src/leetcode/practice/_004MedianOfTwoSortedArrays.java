package leetcode.practice;

import java.util.Arrays;

public class _004MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        _004MedianOfTwoSortedArrays medianOfTwoSortedArrays = new _004MedianOfTwoSortedArrays();
        double ret = medianOfTwoSortedArrays
                .findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 });
        System.out.println(ret);
        ret = medianOfTwoSortedArrays
                .findMedianSortedArrays(new int[] { 1, 5, 7}, new int[] { 3, 4, 6, 8});
        System.out.println(ret);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) %2 == 0) {
            int find1 = findk(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length) /2);
            int find2 = findk(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length) /2 -1);

            return (double)(find1+ find2)/2;
        } else {
            return findk(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length) /2);
        }
    }

    private int findk(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        System.out.println("now array: " +
//                Arrays.toString(Arrays.copyOfRange(nums1, start1, end1)) +  ", " +
//                Arrays.toString(Arrays.copyOfRange(nums2, start2, end2)));
//        System.out.println("k is " + k);

        if (start1 == end1) {
            return nums2[start2 + k];
        }
        if (start2 == end2) {
            return nums1[start1 + k];
        }

        int mid1Index = (end1 - start1)/2;
        int mid2Index = (end2 - start2)/2;

        if (nums1[start1 + mid1Index] > nums2[start2 + mid2Index]) {
            int[] tmpa = nums1;
            nums1 = nums2;
            nums2 = tmpa;

            int tmp = start1;
            start1 = start2;
            start2 = tmp;

            tmp = end1;
            end1 = end2;
            end2 = tmp;

            tmp = mid1Index;
            mid1Index = mid2Index;
            mid2Index = tmp;
        }

//        System.out.println(mid1Index);
//        System.out.println(mid2Index);


        if (k < mid1Index + mid2Index + 1) {
            return findk(nums1, start1, end1, nums2, start2, start2 + mid2Index, k);
        } else {
            return findk(nums1, start1+mid1Index+1, end1, nums2, start2, end2, k-mid1Index-1);
        }

    }
}

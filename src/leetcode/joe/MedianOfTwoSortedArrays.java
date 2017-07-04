package leetcode.joe;

/**
 * Created by joe321 on 2017/4/14.
 */
public class MedianOfTwoSortedArrays {
    int [] nums1;
    int [] nums2;

    //k start from 0
    public int findKthNum(int start1, int length1, int start2, int length2, int k) {

//        System.out.println(start1 + " # " + length1 + " : " + start2 + " # " + length2 + " : " + k);

        if (length1 > length2) {
            //make sure length1 always <= length2
            int [] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            return findKthNum(start2, length2, start1, length1, k);
        }

        if (length1 == 0) {
            return nums2[start2 + k];
        }

        if (length2 == 0) {
            return nums1[start1 + k];
        }

        if (k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int p1 = (k-1)/2 < length1 - 1 ? (k-1)/2: length1 - 1;
        int p2 = k - 1 - p1;

//        System.out.println("p1 is " + p1 + " , p2 is " + p2);
//        System.out.println(nums1[start1 + p1] + " : " + nums2[start2 + p2]);
        if (nums1[start1 + p1] < nums2[start2 + p2]) {
            //remove num before p1 in nums1, include p1, and after p2 in nums2
            return findKthNum(start1 + p1 + 1, length1 - p1 - 1, start2, p2 + 1, k - p1 - 1);
        } else if (nums1[start1 + p1] > nums2[start2 + p2]) {
            //remove num after p1 in nums1, and before p2 in nums2, include p2
            return findKthNum(start1, p1 + 1, start2 + p2 + 1 , length2 - p2 - 1, k - p2 - 1);
        } else {
            return nums1[start1 + p1];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            return findKthNum(0, nums1.length, 0, nums2.length, total/2);
        } else {
            this.nums1 = nums1;
            this.nums2 = nums2;
            double tmp1 = findKthNum(0, nums1.length, 0, nums2.length, total/2);
            this.nums1 = nums1;
            this.nums2 = nums2;
            double tmp2 = findKthNum(0, nums1.length, 0, nums2.length, total/2 - 1);
            return (tmp1 + tmp2)/2;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays
            = new MedianOfTwoSortedArrays();

//        int [] a1 = {1,3};
//        int [] a2 = {2,4};
//        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(a1,a2));
//
//        int [] b1 = {1,3};
//        int [] b2 = {2,4,5};
//        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(b1,b2));

        int [] c1 = {3,4};
        int [] c2 = {};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(c1,c2));


    }
}

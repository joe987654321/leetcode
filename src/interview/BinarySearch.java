package interview;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int [] a = {1,4,4,4,4,15};
        System.out.println(binarySearch.range(a, 0, 0)+ ", " + 0);
        System.out.println(binarySearch.range(a, 0, 1)+ ", " + 1);
        System.out.println(binarySearch.range(a, 0, 3)+ ", " + 1);
        System.out.println(binarySearch.range(a, 0, 4)+ ", " + 5);
        System.out.println(binarySearch.range(a, 0, 15)+ ", " + 6);
        System.out.println(binarySearch.range(a, 0, 16)+ ", " + 6);

        System.out.println(binarySearch.range(a, 1, 1)+ ", " + 1);
        System.out.println(binarySearch.range(a, 1, 3)+ ", " + 1);
        System.out.println(binarySearch.range(a, 1, 4)+ ", " + 5);
        System.out.println(binarySearch.range(a, 1, 15)+ ", " + 6);
        System.out.println(binarySearch.range(a, 1, 16)+ ", " + 6);

        System.out.println(binarySearch.range(a, 3, 3)+ ", " + 0);
        System.out.println(binarySearch.range(a, 3, 4)+ ", " + 4);
        System.out.println(binarySearch.range(a, 3, 15)+ ", " + 5);
        System.out.println(binarySearch.range(a, 3, 16)+ ", " + 5);

        System.out.println(binarySearch.range(a, 4, 4)+ ", " + 4);
        System.out.println(binarySearch.range(a, 4, 15)+ ", " + 5);
        System.out.println(binarySearch.range(a, 4, 16)+ ", " + 5);

        System.out.println(binarySearch.range(a, 15, 15)+ ", " + 1);
        System.out.println(binarySearch.range(a, 15, 16)+ ", " + 1);

        System.out.println(binarySearch.range(a, 16, 16)+ ", " + 0);
    }

    public int range2(int [] a, int k1, int k2) {
        int first = Arrays.binarySearch(a, k1);
        int second = Arrays.binarySearch(a, k2);
        if (first < 0) first = -first-1;
        if (second < 0) second = -second-2;
        return second-first+1;
    }

    public int range(int [] a, int k1, int k2) {

        int first = _range(a, k1, true);
        int second = _range(a, k2, false);
        return second-first+1;
    }

    private int _range(int [] a, int t, boolean left) {
        if (left && t > a[a.length-1]) return a.length;
        if (!left && t < a[0]) return -1;
        int start = 0;
        int end = a.length -1;
        while (end != start) {
            int mid = start + (end-start +(left?0:1))/2;
            if (a[mid] < t) {
                start = mid + (left?1:0);
            } else if (a[mid] > t) {
                end = mid - (left?0:1);
            } else if (left) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }


}

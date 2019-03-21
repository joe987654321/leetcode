package leetcode.practice;

public class _069Sqrtx {
    public static void main(String[] args) {
        _069Sqrtx sqrtx = new _069Sqrtx();
        int x = sqrtx.mySqrt(2147483647);
        System.out.println(x);
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x <= 3) return 1;
        int start = 1;
        int end = x/2;
        while (start < end) {
            int mid = start + (end-start+1)/2;
            long y = (long)mid*(long)mid;
            if (x == y) return mid;
            else if (y > x) end = mid-1;
            else start = mid;
        }
        return start;
    }
}

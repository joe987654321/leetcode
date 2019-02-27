package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class _050PowXN {
    public static void main(String[] args) {
        _050PowXN powXN = new _050PowXN();
        System.out.println(powXN.myPow(2.0, -3));
    }

    double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    //too long
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        long nn = n;
        boolean sign = true;
        if (nn < 0) {
            nn = -nn;
            sign = false;
        }
        List<Double> list = new ArrayList<>();
        long count = 1;
        while (count <= nn) {
            list.add(x);
            x *= x;
            count *= 2;
        }
        count /= 2;
        int indexFromTail = 0;
        double ret = 1;
        while (nn != 0) {
            if (nn >= count) {
                ret *= list.get(list.size() - 1 - indexFromTail);
                nn -= count;
            }
            count /= 2;
            indexFromTail++;
        }
        return sign ? ret : 1 / ret;
    }

}

package leetcode.joe;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean happy = happyNumber.isHappy(19);
        System.out.println(happy);
    }

    public boolean isHappy(int n) {
        if (n <= 0) return false;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            int sum = 0;
            while (n != 0) {
                int tmp = n%10;
                sum += tmp*tmp;
                n/=10;
            }
            n = sum;
        }
        return true;
    }
}

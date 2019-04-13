package leetcode.joe;

public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        boolean powerOfThree1 = powerOfThree.isPowerOfThree(3);
        System.out.println(powerOfThree1);
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if (n%3 != 0) return false;
            n /=3;
        }
        return true;
    }
}

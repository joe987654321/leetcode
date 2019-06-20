package leetcode.joe;

public class PowerofFour {
    public static void main(String[] args) {

    }

    public boolean isPowerOfFour(int num) {
        return num>0 && (num&(num-1))==0 && (num&0x55555555)>0;
    }
}

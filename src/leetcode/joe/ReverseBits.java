package leetcode.joe;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        int i = reverseBits.reverseBits(-3);
        System.out.println(i);
    }

    public int reverseBits(int n) {
        int mask = 1;
        int out = 0;
        for (int i = 0; i < 32; i++) {
            out <<= 1;
            if ((mask & n) != 0) {
                out += 1;
            }
            mask <<= 1;
        }
        return out;
    }
}

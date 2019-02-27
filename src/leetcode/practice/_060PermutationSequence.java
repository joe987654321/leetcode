package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class _060PermutationSequence {
    public static void main(String[] args) {
        _060PermutationSequence permutationSequence = new _060PermutationSequence();
        String permutation = permutationSequence.getPermutation(9, 157891);
        System.out.println(permutation);
    }

    public String getPermutation(int n, int k) {
        if (n == 1 && k == 1) {
            return "1";
        }
        int[] ladder = new int[n];
        ladder[0] = 1;
        for (int i = 1; i < n; i++) {
            ladder[i] = ladder[i-1] * i;
        }
        List<String> balls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            balls.add(i + "");
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i <= n; i++) {
            int order = k / ladder[n-i];
            sb.append(balls.get(order));
            balls.remove(order);
            k %= ladder[n-i];
        }
        return sb.toString();
    }
}

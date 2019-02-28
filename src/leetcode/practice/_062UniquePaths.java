package leetcode.practice;

public class _062UniquePaths {
    public static void main(String[] args) {
        _062UniquePaths uniquePaths = new _062UniquePaths();
        int i = uniquePaths.uniquePaths(51, 9);
        System.out.println(i);
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m<n) return uniquePaths(n,m);
        m--;
        n--;
        int total = m+n;
        long ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= total+1-i;
            ret /= i;
        }
        return (int)ret;
    }
}

package leetcode.practice100;

public class _096UniqueBinarySearchTrees {
    public static void main(String[] args) {
        _096UniqueBinarySearchTrees uniqueBinarySearchTrees = new _096UniqueBinarySearchTrees();
        int i = uniqueBinarySearchTrees.numTrees(4);
        System.out.println(i);
    }

    public int numTrees(int n) {
        //formula: C(2n, n) - C(2n, n+1) = C(2n,n) / (n+1)
        long now = 1;
        for (int i = 0; i < n; i++) {
            now *= 2*n-i;
            now /= i+1;
        }
        return (int)(now/(n+1));
    }
}

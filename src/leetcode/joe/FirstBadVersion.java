package leetcode.joe;

public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int b = firstBadVersion.firstBadVersion(2);
        System.out.println(b);
    }

    boolean isBadVersion(int version) {
        return version >= 3;
    }

    public int firstBadVersion(int n) {
        if (n<=0) return 0;
        int start = 1;
        int end = n;
        while (end > start) {
            int mid = start + (end-start)/2;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }
        return isBadVersion(end) ? end: end+1;
    }
}

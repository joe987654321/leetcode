package leetcode.practice100;

public class _028ImplementStrStr {

    //KMP
    public static void main(String[] args) {
        _028ImplementStrStr implementStrStr = new _028ImplementStrStr();
        int i = implementStrStr.strStr("babba", "bbb");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }

        int[] f = new int[needle.length()];
        f[0] = -1;
        for (int i = 1; i < needle.length(); i++) {
            int j = f[i-1];
            while (j >= 0 && needle.charAt(j+1) != needle.charAt(i)) j = f[j];
            if (needle.charAt(j+1) == needle.charAt(i)) j++;
            f[i] = j;
        }

        //System.out.println(Arrays.toString(f));

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && needle.charAt(j+1) != haystack.charAt(i)) j = f[j];
            if (needle.charAt(j+1) == haystack.charAt(i)) j++;
            if (j == needle.length()-1) {
                return i-needle.length()+1;
            }
        }
        return -1;
    }
}

package leetcode.practice100;

public class _014LongestCommonPrefix {
    public static void main(String[] args) {
        _014LongestCommonPrefix longestCommonPrefix = new _014LongestCommonPrefix();
        String ret = longestCommonPrefix.longestCommonPrefix(new String[] { "flower", "flow", "flight" });
        System.out.println(ret);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (true) {
            if (start >= strs[0].length()) {
                return sb.toString();
            }
            char c = strs[0].charAt(start);
            for (int i = 1; i < strs.length; i++) {
                if (start >= strs[i].length() || strs[i].charAt(start) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            start++;
        }
    }
}

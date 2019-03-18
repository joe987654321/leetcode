package leetcode.joe;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String s = removeDuplicateLetters.removeDuplicateLetters("cbacdcbc");
        System.out.println(s);
    }

    public String removeDuplicateLetters(String s) {
        if (s == null) return null;
        if (s.length() == 0) return "";
        int [] count = new int[26];
        boolean [] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder("0");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c-'a']--;
            if (visited[c-'a']) continue;
            while (c < sb.charAt(sb.length()-1) && count[sb.charAt(sb.length()-1) - 'a'] > 0) {
                visited[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            visited[c-'a'] = true;
            sb.append(c);
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
}

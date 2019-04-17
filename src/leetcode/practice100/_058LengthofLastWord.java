package leetcode.practice100;

public class _058LengthofLastWord {
    public static void main(String[] args) {
        _058LengthofLastWord lengthofLastWord = new _058LengthofLastWord();
        int hello_world = lengthofLastWord.lengthOfLastWord("a ");
        System.out.println(hello_world);
    }

    public int lengthOfLastWord(String s) {
        int end = s.length()-1, ret = 0;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        while(end >= 0 && s.charAt(end) != ' ') {
            end--;
            ret++;
        }
        return ret;
    }
}

package leetcode.joe;

/**
 * Created by joe321 on 2017/6/22.
 */
public class CountandSay {

    public String countAndSay(int n) {
        String init = "1";
        for (int i = 1; i < n; i++) {
            init = next(init);
        }
        return init;
    }

    private String next(String input) {
        StringBuilder sb = new StringBuilder("");
        char c = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (c == input.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                count = 1;
                c = input.charAt(i);
            }
        }
        if (count != 0) {
            sb.append(count);
            sb.append(c);
        }
      //  System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        CountandSay countandSay = new CountandSay();
        System.out.println(countandSay.countAndSay(10));
    }
}

package leetcode.joe;

import java.util.List;

public class BullsandCows {
    public static void main(String[] args) {
        BullsandCows bullsandCows = new BullsandCows();
        String hint = bullsandCows.getHint("1123", "0111");
        System.out.println(hint);
    }

    public String getHint(String secret, String guess) {
        if (secret == null ||guess == null) return null;
        if (secret.length() == 0) return "0A0B";
        int countA = 0;
        int[] map = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                map[secret.charAt(i)-'0']++;
            }
        }
        int countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && map[guess.charAt(i)-'0'] > 0) {
                map[guess.charAt(i)-'0']--;
                countB++;
            }
        }
        return countA + "A" + countB + "B";
    }
}

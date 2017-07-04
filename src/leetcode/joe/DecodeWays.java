package leetcode.joe;

/**
 * Created by joe321 on 2017/1/25.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 1;
        }
        int [] noLeft = new int[s.length()];
        int [] leftA = new int[s.length()];
        int [] leftB = new int[s.length()];

        char [] sCharArray = s.toCharArray();

        //init
        if (sCharArray[0] == '0') {
            return 0;
        } else if (sCharArray[0] == '1') {
            noLeft[0] = 1;
            leftA[0] = 1;
            leftB[0] = 0;
        } else if (sCharArray[0] == '2') {
            noLeft[0] = 1;
            leftA[0] = 0;
            leftB[0] = 1;
        } else {
            noLeft[0] = 1;
            leftA[0] = 0;
            leftB[0] = 0;
        }

        for (int i = 1; i < sCharArray.length ; i++) {
            if (sCharArray[i]=='0') {
                leftA[i] = leftB[i] = 0;
                noLeft[i] = leftA[i-1] + leftB[i-1];
                if (noLeft[i] == 0) {
                    return 0;
                }
            } else if (sCharArray[i]=='1') {
                leftB[i] = 0;
                leftA[i] = noLeft[i-1];
                noLeft[i] = noLeft[i-1] + leftA[i-1] + leftB[i-1];
            } else if (sCharArray[i]=='2') {
                leftA[i] = 0;
                leftB[i] = noLeft[i-1];
                noLeft[i] = noLeft[i-1] + leftA[i-1] + leftB[i-1];
            } else {
                leftA[i] = leftB[i] = 0;
                noLeft[i] = noLeft[i-1] + leftA[i-1];
                if (sCharArray[i] == '3' || sCharArray[i] == '4' || sCharArray[i] == '5' || sCharArray[i] == '6') {
                    noLeft[i] += leftB[i-1];
                }
            }
        }

        return noLeft[s.length()-1];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("1239123"));
    }
}

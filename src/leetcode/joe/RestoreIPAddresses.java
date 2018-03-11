package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> strings;
        // strings = restoreIPAddresses.restoreIpAddresses("25525511135");
     //   System.out.println(strings);
        strings = restoreIPAddresses.restoreIpAddresses("010010");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();

        String [] stringArray = new String[3];
        _restoreIpAddress(ret, s, stringArray, 0);

        return ret;
    }

    private void _restoreIpAddress(List<String> ret, String s, String[] stringArray, int tryIndex) {
        if (tryIndex == 3) {
            if (s.charAt(0) == '0' && s.length() != 1) {
                return;
            }

            if (Integer.parseInt(s) > 255) {
                return;
            }

            ret.add(stringArray[0] +'.'+ stringArray[1] +'.'+stringArray[2] +'.'+ s);
            return;
        }
        int minNext = 3-tryIndex;
        int maxNext = 3*(3-tryIndex);

        for (int i = 1; i <= 3; i++) {
            if (s.length() - i < minNext) {
                break;
            }
            if (s.length() - i > maxNext) {
                continue;
            }

            if (s.charAt(0) == '0' && i > 1) {
                break;
            }

            String tmp = s.substring(0, i);

            if (i == 3 && Integer.parseInt(tmp) > 255) {
                break;
            }

            stringArray[tryIndex] = tmp;
            _restoreIpAddress(ret, s.substring(i, s.length()), stringArray, tryIndex+1);
            stringArray[tryIndex] = null;
        }


    }

}

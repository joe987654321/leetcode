package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

public class _093RestoreIPAddresses {
    public static void main(String[] args) {
        _093RestoreIPAddresses restoreIPAddresses = new _093RestoreIPAddresses();
        List<String> strings = restoreIPAddresses.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return ret;
        _restore(ret, s , new ArrayList<>(), 0);
        return ret;
    }

    private void _restore(List<String> ret, String s, List<String> now, int idx) {
        if (now.size() == 4) {
            if (idx == s.length()) {
                String sb = now.get(0) + '.' + now.get(1) + '.' + now.get(2) + '.' + now.get(3);
                ret.add(sb);
            }
            return;
        }
        int left = 4 - now.size();
        if (s.length() - idx < left || s.length() - idx > 3 * left) return;
        for (int i = 1; i <= 3; i++) {
            if (idx + i > s.length()) return;
            if (i != 1 && s.charAt(idx) == '0') return;
            int ip = Integer.parseInt(s.substring(idx, idx+i));
            if (ip <= 255) {
                now.add(String.valueOf(ip));
                _restore(ret, s, now, idx+i);
                now.remove(now.size()-1);
            }
        }
    }
}

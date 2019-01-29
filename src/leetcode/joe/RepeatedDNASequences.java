package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        List<String> ret = repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAAA");
        System.out.println(ret);

    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        if (s.length() <= 10) {
            return ret;
        }
        byte[] exist = new byte[1024*1024];
        char[] input = s.toCharArray();
        int now = 0;
        for (int i = 0; i < 10; i++) {
            now*=4;
            now += toNum(input[i]);
        }
        exist[now] = 1;
        for (int i = 10; i < input.length; i++) {
            now -= toNum(input[i-10])*1024*256;
            now *=4;
            now += toNum(input[i]);
            if (exist[now] == 1) {
                ret.add(new String(input, i-9, 10));
                exist[now] = 2;
            } else if (exist[now] == 0) {
                exist[now] = 1;
            }
        }
        return ret;
    }

    private int toNum(char c) {
        switch (c) {
            case 'A': return 0;
            case 'T': return 1;
            case 'C': return 2;
            case 'G': return 3;
        }
        return -1;
    }
}

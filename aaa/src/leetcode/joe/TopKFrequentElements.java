package leetcode.joe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joe321 on 2016/12/28.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }

        Map<Integer, Integer> frequence = new HashMap<Integer, Integer>();
        int max = 1;
        for (int num: nums) {
            Integer count = frequence.get(num);
            if (count == null) {
                frequence.put(num, 1);
            } else {
                frequence.put(num, count + 1);
                if (count + 1 > max) {
                    max = count + 1;
                }
            }
        }

        List<Integer> [] bucket = (List<Integer> []) new ArrayList[max];
        for (int key: frequence.keySet()) {
            int freq = frequence.get(key);
            if (bucket[freq-1] == null) {
                bucket[freq-1] = new ArrayList<>();
            }
            bucket[freq-1].add(key);
        }

        int nowAdded = 0;
        for (int i = max-1; i>=0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (int num: bucket[i]) {
                ret.add(num);
                nowAdded++;
                if (nowAdded == k) {
                    return ret;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int [] a = {1};
        int k = 1;
        System.out.println(topKFrequentElements.topKFrequent(a,k));
    }
}

package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        return recursive(cache, nums, target);
    }

    private int recursive(Map<Integer, Integer> cache, int[] nums, int target) {
        int total = 0;
        for (int select: nums) {
            if (select > target) {
                break;
            }
            if (select == target) {
                total++;
            }
            if (select < target) {
                if (cache.get(target-select) != null) {
                    total += cache.get(target-select);
                } else {
                    cache.put(target-select, recursive(cache, nums, target-select));
                    total += cache.get(target-select);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        CombinationSumIV cs = new CombinationSumIV();
        System.out.println(cs.combinationSum4(new int[] {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300,310,320,330,340,350,360,370,380,390,400,410,420,430,440,450,460,470,480,490,500,510,520,530,540,550,560,570,580,590,600,610,620,630,640,650,660,670,680,690,700,710,720,730,740,750,760,770,780,790,800,810,820,830,840,850,860,870,880,890,900,910,920,930,940,950,960,970,980,990,111}, 999));

    }

}

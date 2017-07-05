package leetcode.joe;

/**
 * Created by joe321 on 2017/7/5.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int head = 0;
        int tail = height.length-1;
        int nowWater = 0;
        int canStoreWaterHeight = Math.min(height[head], height[tail]);
        while (head != tail) {
            if (height[head] > height[tail]) {
                tail--;
                if (height[tail] < canStoreWaterHeight) {
                    nowWater += canStoreWaterHeight - height[tail];
                } else {
                    canStoreWaterHeight = Math.min(height[head], height[tail]);
                }
            } else {
                head++;
                if (height[head] < canStoreWaterHeight) {
                    nowWater += canStoreWaterHeight - height[head];
                } else {
                    canStoreWaterHeight = Math.min(height[head], height[tail]);
                }
            }
        }
        return nowWater;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));
    }
}

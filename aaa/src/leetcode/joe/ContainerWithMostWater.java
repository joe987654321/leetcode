package leetcode.joe;

/**
 * Created by joe321 on 2017/4/17.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length -1;

        int maxArea = Math.min(height[last], height[first]) * (last-first);
        while (last != first) {
            if (height[last] > height[first]) {

                first ++;
                int newArea = Math.min(height[last], height[first])*(last-first);
                if (maxArea < newArea) {
                    maxArea = newArea;
                }
            } else {
                last --;
                int newArea = Math.min(height[last], height[first])*(last-first);
                if (maxArea < newArea) {
                    maxArea = newArea;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int [] a = {2,3,6,5,7,4,1};
        System.out.println(containerWithMostWater.maxArea(a));
    }
}

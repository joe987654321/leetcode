package leetcode.joe;

/**
 * Created by Joe on 2017/6/4.
 */
public class Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int flowerIndex = 0;
        int continueZero = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continueZero = 0;
            } else {
                continueZero++;
            }
            //System.out.println("cz:" + continueZero);
            if (continueZero >= 3 && continueZero%2 == 1) {
                flowerIndex++;
                if (flowerIndex == n) {
                    return true;
                }
            }
        }
        if (continueZero >= 2 && continueZero%2==0 && flowerIndex == n-1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Flowers flowers = new Flowers();
        int [] a = {1,0,0,0,0};
        boolean b = flowers.canPlaceFlowers(a,2);
        System.out.println(b);
    }
}

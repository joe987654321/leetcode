package leetcode.joe;

/**
 * Created by joe321 on 2017/1/19.
 */
public class WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y) {
            return true;
        }
        if (x <= 0 || y <= 0) {
            return false;
        }
        if (x+y < z) {
            return false;
        }

        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        //y>=x now

        while (true) {
            int reminder = y%x;
            if (reminder == 0) {
                break;
            } else {
                y = x;
                x = reminder;
            }
        }

        if (z%x == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        WaterAndJugProblem waterAndJugProblem = new WaterAndJugProblem();
        int x = 8;
        int y = 5;
        int z = 4;
        System.out.println(waterAndJugProblem.canMeasureWater(x,y,z));
    }
}

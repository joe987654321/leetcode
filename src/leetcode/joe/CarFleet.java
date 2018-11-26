package leetcode.joe;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CarFleet {

    public static void main(String[] args) {
        int target = 10;
        int [] position = {2,4};
        int [] speed = {3,2};

        CarFleet carFleet = new CarFleet();

        System.out.println(carFleet.carFleet(target, position, speed));


    }

    public static class Two {
        Integer first;
        Integer second;
        Two(int i, int j) {first = i; second = j;}
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }

        Two[] _position = new Two[position.length];
        for (int i = 0; i < _position.length; i++) {
            _position[i] = new Two(position[i], speed[i]);
        }

        Arrays.sort(_position, new Comparator<Two>() {
            @Override public int compare(Two o1, Two o2) {
                return -Integer.compare(o1.first, o2.first);
            }
        });



        double preTime = (double)(target - _position[0].first) / _position[0].second;
        int ret = 1;
        for (int i = 1; i < position.length; i++) {
            double nowTime = (double)(target - _position[i].first) / _position[i].second;
            if (nowTime > preTime) {
                ret++;
                preTime = nowTime;
            }
        }
        return ret;
    }
}

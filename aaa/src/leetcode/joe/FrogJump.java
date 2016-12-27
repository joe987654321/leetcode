package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2016/12/27.
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return false;
        }

        int len = stones.length;


        //At index 0 can jump 1 unit
        int [] maxJump = new int[len];
        maxJump[0] = 1;

        //set index 0 preJumpStep to {0}, for convenience

        List<Integer> [] preJumpSteps = (List<Integer>[]) new ArrayList[len];
        for (int i=0;i<len;i++) {
            preJumpSteps[i] = new ArrayList<>();
        }
        preJumpSteps[0].add(0);

        for (int i = 0;i<len;i++) {
        //    System.out.println(stones[i] + ":" + preJumpSteps[i]);
            for (int j=i+1; j<len;j++) {
                if (maxJump[i] + stones[i] < stones[j]) {
                    //too long, can't jump
                    break;
                }
                for (Integer preJumpStep: preJumpSteps[i]) {
                    if (stones[j] - stones[i] == preJumpStep - 1
                     || stones[j] - stones[i] == preJumpStep
                     || stones[j] - stones[i] == preJumpStep + 1 ) {
                        preJumpSteps[j].add(stones[j] - stones[i]);
                        if (stones[j] - stones[i] + 1 > maxJump[j]) {
                            maxJump[j] = stones[j] - stones[i] + 1;
                        }
                        //add i -> j jump, skip other i step check
                        break;
                    }
                }
            }
        }

        return (maxJump[len -1] != 0);
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int [] a = {0,1,2,3,4,8,9,11};
        System.out.println(frogJump.canCross(a));
    }
}

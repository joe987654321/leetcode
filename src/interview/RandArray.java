package interview;

public class RandArray {
    public static int [] getRandArray(int n) {
        int [] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = i;
        }

        //Rand
        for (int i = 1; i < n; i++) {
            int randIndex = (int)(Math.random() * i);
            int tmp = ret[randIndex];
            ret[randIndex] = ret[i];
            ret[i] = tmp;
        }

        return ret;
    }
}

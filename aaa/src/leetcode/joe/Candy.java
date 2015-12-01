package leetcode.joe;

public class Candy {
    public static class Solution {
        public int candy(int[] ratings) {
            int total = ratings.length;
            int [] candys = new int[total];

            for (int i =0; i < total ; i++) {
                boolean setOne = true;
                if (i-1>=0) {
                    if (ratings[i] > ratings[i-1]) {
                        setOne = false;
                    }
                }
                if (i+1<total) {
                    if (ratings[i] > ratings[i+1]) {
                        setOne = false;
                    }
                }
                if (setOne) {
                    candys[i] = 1;
                }
            }
            String s = "aaa";
            s.length();
            for (int i = 0; i < total ; i++) {
                if (candys[i] == 1) {
                    int count = 2;
                    for (int j = 1; ; j++) {
                        if (i-j >= 0 && ratings[i-j] > ratings[i-j+1] && candys[i-j] < count) {
                            candys[i-j] = count;
                            count++;
                        } else {
                            break;
                        }
                    }
                    count = 2;
                    for (int j = 1; ; j++) {
                        if (i+j < total  && ratings[i+j] > ratings[i+j-1] && candys[i+j] < count) {
                            candys[i+j] = count;
                            count++;
                        } else {
                            break;
                        }
                    }
                }
            }

            int totalCandys = 0;
            for (int i = 0; i < total ; i++) {
                totalCandys += candys[i];
            }

            return totalCandys;
        }
    }

    public static void main(String [] args){
        Solution s= new Solution();
        int [] aaa = {2,1};
        System.out.println(s.candy(aaa));
    }
}

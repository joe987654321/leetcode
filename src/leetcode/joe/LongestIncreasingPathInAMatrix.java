package leetcode.joe;

import leetcode.util.DebugUtils;

import java.util.*;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        int [][] input = new int[][] {{9,6,4},{6,6,8},{2,1,0}};
        int ret = longestIncreasingPathInAMatrix.longestIncreasingPath(input);
        System.out.println(ret);
    }

    private static int[][] shift = {{0,1},{0,-1},{1,0},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int [][] ans = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(ans, matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] ans, int[][] matrix, int x, int y) {
        if (ans[x][y] != 0) return ans[x][y];
        int max = 1;
        for (int[] dir: shift) {
            int nowx = x+ dir[0];
            int nowy = y + dir[1];
            if (valid(nowx,nowy,matrix) && matrix[nowx][nowy] > matrix[x][y]) {
                max = Math.max(max, 1+dfs(ans, matrix, nowx, nowy));
            }
        }
        ans[x][y] = max;
        return max;
    }

    private boolean valid(int x, int y, int[][] matrix) {
        return x>=0 && x < matrix.length && y>=0 && y< matrix[0].length;
    }

    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        Queue<Integer> startx = new LinkedList<>();
        Queue<Integer> starty = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean isRoot = true;
                for (int k = 0; k < 4; k++) {
                    int x = i+shift[k][0];
                    int y = j+shift[k][1];
                    if (valid(x, y, matrix) && matrix[x][y] < matrix[i][j]) {
                        isRoot = false;
                        break;
                    }
                }
                if (isRoot) {
                    startx.add(i);
                    starty.add(j);
                }
            }
        }

        int [][] cache = new int[matrix.length][matrix[0].length];

        int max = 0;

        while(!startx.isEmpty()) {
            Queue<Integer> xs = new LinkedList<>();
            Queue<Integer> ys = new LinkedList<>();
            xs.add(startx.poll());
            ys.add(starty.poll());
            int level = 0;

            while (!xs.isEmpty()) {
                int count = xs.size();
                level++;
                while (count-- > 0) {
                    int nowx = xs.poll();
                    int nowy = ys.poll();
                    for (int i = 0; i < 4; i++) {
                        int x = nowx + shift[i][0];
                        int y = nowy + shift[i][1];
                        if (valid(x, y, matrix) && cache[x][y] < level && matrix[x][y] > matrix[nowx][nowy]) {
                            xs.add(x);
                            ys.add(y);
                            cache[x][y] = level;
                        }
                    }
                }
            }
            max = Math.max(max, level);
            //DebugUtils.print2DArray(cache);
        }
        return max;
    }
}

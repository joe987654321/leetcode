package leetcode.joe;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char [][] grid = new char[][] {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1},
        };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += '0';
            }
        }
        int i = numberOfIslands.numIslands(grid);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    setSameComponentToVisited(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private int[][] shift = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}} ;

    private void setSameComponentToVisited(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (valid(grid, visited, x+shift[i][0], y+shift[i][1])) {

                setSameComponentToVisited(grid, visited, x+shift[i][0], y+shift[i][1]);
            }
        }
    }

    private boolean valid(char[][] grid, boolean[][] visited, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1' && !visited[x][y];
    }

}

class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int max = 0;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    max = Math.max(dfs(i,j,grid), max);
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int[][] grid){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;

        for(int[] dir : directions){
            int row = dir[0] + r;
            int col = dir[1] + c;
            area += dfs(row,col,grid);
        }
        return area;
    }
}

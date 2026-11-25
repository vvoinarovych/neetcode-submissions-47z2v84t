class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int result = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){                    
                    result = Math.max(result, dfs(i,j,grid));
                }
            }
        }
        return result;
    }

     private int dfs(int r, int c, int[][] grid){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        int result = 1;
        for(int[] d : directions){
            int row = d[0] + r;
            int col = d[1] + c;
            result += dfs(row, col, grid);
        }
        return result;
    }
}

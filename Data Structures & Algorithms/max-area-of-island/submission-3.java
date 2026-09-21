class Solution {
    int[][] directions = new int[][]{
        {-1,0},{1,0},{0,1},{0,-1}
    };
    int ROWS;
    int COLS;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int max = 0;

        for(int i = 0; i < ROWS;i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j, grid));                    
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int[][] grid){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0){
            return 0;
        }
        int counter = 1;
        grid[r][c] = 0;
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];            
            counter += dfs(row, col, grid);
        }
        return counter;
    }
}

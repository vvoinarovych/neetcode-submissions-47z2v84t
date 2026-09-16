class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c){
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] directions = new int[][]{
            {0 , 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for(int[] dir : directions){
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}

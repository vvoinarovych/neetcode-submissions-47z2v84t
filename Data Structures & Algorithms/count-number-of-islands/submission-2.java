class Solution {
    int[][] directions = new int[][]{
        {-1,0}, {1,0},{0,1},{0,-1}
    };
    int COLS;
    int ROWS;
    public int numIslands(char[][] grid) {
        COLS = grid[0].length;
        ROWS = grid.length;
        int count = 0;

        for(int i = 0; i < ROWS;i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            dfs(grid, row, col);
        }
    }
}

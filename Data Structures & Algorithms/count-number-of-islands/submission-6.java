class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';

        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            dfs(row, col, grid);
        }
    }
}

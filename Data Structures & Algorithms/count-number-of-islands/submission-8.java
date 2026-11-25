class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int counter = 0;
        ROWS = grid.length;
        COLS = grid[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    counter++;
                    dfs(i,j,grid);
                }
            }
        }
        return counter;
    }

    private void dfs(int r, int c, char[][] grid){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        for(int[] d : directions){
            int row = d[0] + r;
            int col = d[1] + c;
            dfs(row, col, grid);
        }
    }
}

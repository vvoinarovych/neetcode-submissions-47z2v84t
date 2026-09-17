class Solution {
    int[][] directions = new int[][]{
        {-1,0}, {1,0},{0,1},{0,-1}
    };
    int COLS;
    int ROWS;
    public int maxAreaOfIsland(int[][] grid) {
        COLS = grid[0].length;
        ROWS = grid.length;
        int max = 0;

        for(int i = 0; i < ROWS;i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,dfs(grid, i, j));                    
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c){        
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;  
        int counter = 1;     
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            counter+= dfs(grid, row, col);
        }
        return counter;
    }
}

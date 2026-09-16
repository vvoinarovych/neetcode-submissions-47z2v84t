class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j);
                }
            }
        }
        return max;
    }

    public void bfs(int[][] grid, int r, int c){
        int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        int counter = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            
            counter++;
            
            for(int[] dir : directions){
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] == 1){
                    grid[row][col] = 0;
                    q.offer(new int[]{row, col});
                }
            }
        }
        max = Math.max(max, counter);
    }
}

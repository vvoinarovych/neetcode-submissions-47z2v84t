class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();            
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                for(int[] dir : directions){
                    int row = dir[0] + cell[0];
                    int col = dir[1] + cell[1];
                    if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            if(!q.isEmpty()) time++;            
        }
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}

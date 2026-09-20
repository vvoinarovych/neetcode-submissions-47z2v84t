class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int time = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] current = q.poll();
                for(int[] dir : directions){
                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];
                    if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            if(!q.isEmpty()) time++;
        }
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}

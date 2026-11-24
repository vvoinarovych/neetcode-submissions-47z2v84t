class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] directions = new int[][]{
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };

        int minutes = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];
                for(int[] d : directions){
                    int row = x + d[0];
                    int col = y + d[1];
                    if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            if(!q.isEmpty()){
                minutes++;
            }
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minutes;
    }
}

class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][]{
        {-1,0}, {1,0},{0,1},{0,-1}
    };
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int counter = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] node = q.poll();
                for(int[] dir : directions){
                    int row = node[0] + dir[0];
                    int col = node[1] + dir[1];
                    if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            if(!q.isEmpty()){
                counter++;
            }
        }
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return counter;
    }
}

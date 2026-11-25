class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];
                for(int[] d : directions){
                    int row = d[0] + r;
                    int col = d[1] + c;
                    if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] == Integer.MAX_VALUE){
                        grid[row][col] = time;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            time++;
        }
    }
}

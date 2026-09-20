class Solution {
    int[][] directions = new int[][]{
        {-1,0},{1,0},{0,-1},{0,1}
    };
    boolean[][] can;
    int ROWS;
    int COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        can = new boolean[ROWS][COLS];
        for(int i = 0; i < COLS; i++){
            dfs(0,i,board);
            dfs(ROWS - 1, i, board);
        }
        for(int i = 1; i < ROWS - 1; i++){
            dfs(i,0,board);
            dfs(i,COLS-1,board);
        }
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(!can[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        if(board[r][c] == 'O'){
            can[r][c] = true;
        }else{
            return;
        }
        can[r][c] = true;
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            if(row >= 0 && col >= 0 && row < ROWS && col < COLS && board[row][col] == 'O' && !can[row][col]){
                dfs(row, col, board);
            }
            
        }
    }
}

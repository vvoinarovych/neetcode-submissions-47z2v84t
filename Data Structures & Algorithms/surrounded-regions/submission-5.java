class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        boolean[][] canReach = new boolean[ROWS][COLS];
        for(int i = 0; i < COLS; i++){
            dfs(0, i, canReach, board);
            dfs(ROWS - 1, i, canReach, board);
        }
        for(int i = 1; i < ROWS - 1; i++){
            dfs(i, 0, canReach, board);
            dfs(i, COLS-1, canReach, board);
        }
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == 'O' && !canReach[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, boolean[][] canReach, char[][] board){
        if(board[r][c] == 'O'){
            canReach[r][c] = true;
        }else{
            return;
        }
        canReach[r][c] = true;    
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            if(row >= 0 && col >= 0 && row < ROWS && col < COLS && board[row][col] == 'O' && !canReach[row][col]){
                dfs(row, col, canReach, board);
            }
            
        }
    }
}

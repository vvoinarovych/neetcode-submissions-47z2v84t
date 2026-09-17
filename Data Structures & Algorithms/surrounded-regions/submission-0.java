class Solution {
    int[][] directions = new int[][]{
        {1,0},{-1,0},{0,1},{0,-1}
    };
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] canReach = new boolean[ROWS][COLS];
        for(int i = 0; i < COLS; i++){
            dfs(0, i, board, canReach);
            dfs(ROWS-1, i, board, canReach);
        }
        for(int i = 1; i < ROWS - 1; i++){
            dfs(i, 0, board, canReach);
            dfs(i, COLS-1, board, canReach);
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == 'O' && !canReach[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] board, boolean[][] canReach){
        if(board[r][c] == 'O'){
            canReach[r][c] = true;
        }else{
            return;
        }
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            if(row >= 0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] == 'O' && canReach[row][col] == false){
                dfs(row, col, board, canReach);
            }
        }
    }
}

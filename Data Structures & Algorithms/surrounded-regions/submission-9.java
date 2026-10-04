class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] can;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        can = new boolean[ROWS][COLS];

        for (int i = 0; i < COLS; i++) {
            dfs(0, i, board);
            dfs(ROWS - 1, i, board);
        }

        for(int i = 1; i < ROWS - 1; i++){
            dfs(i, 0, board);
            dfs(i, COLS - 1, board);
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == 'O' && !can[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != 'O' || can[r][c]){
            return;
        }
        can[r][c] = true;
        for(int[] d : directions){
            int row = d[0] + r;
            int col = d[1] + c;
            dfs(row, col, board);
        }
    }
}

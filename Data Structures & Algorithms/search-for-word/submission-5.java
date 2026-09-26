class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == word.charAt(0)){
                   if(dfs(i, j, 0, board, word)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i, char[][] board, String word){
        if(board[r][c] != word.charAt(i) || board[r][c] == '@'){
            return false;
        }
        if(i == word.length() - 1) return true;
        boolean result = false;
        board[r][c] = '@';
        for(int[] dir : directions){
            int row = dir[0] + r;
            int col = dir[1] + c;
            if(row >= 0 && col >= 0 && row < ROWS && col < COLS && dfs(row, col, i + 1, board, word)){
                result = true;
                if(result) break;
            }            
        }
        board[r][c] = word.charAt(i);

        return result;
    }
}

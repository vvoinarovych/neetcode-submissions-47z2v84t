class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i,j,0,word,board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int id, String w, char[][] board){
        if(id == w.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != w.charAt(id)){
            return false;
        }
        board[r][c] = '@';
        boolean result = false;
        for(int dir[] : directions){
            int row = dir[0] + r;
            int col = dir[1] + c;
            if(dfs(row, col, id + 1, w, board)){
                result = true;
                break;
            }
        }
        board[r][c] = w.charAt(id);
        return result;
    }
}

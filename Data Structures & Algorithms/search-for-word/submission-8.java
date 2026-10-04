class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][]{
        {-1,0}, {1, 0}, {0,1}, {0,-1}
    };
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(dfs(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int id, String word, char[][] board){
        if(id == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(id)){
            return false;
        }
        
        board[r][c] = '@';
        boolean result = false;
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            if(dfs(row, col, id + 1, word, board)){
                result = true;
                break;
            }
        }
        board[r][c] = word.charAt(id);
        return result;
    }
}

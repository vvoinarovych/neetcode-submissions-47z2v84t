class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int id, char[][] board, String word){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(id)){
            return false;
        }
        if(id == word.length()-1) return true;
        board[r][c] = '@';
        boolean result = false;
        for(int[] dir : directions){
            int row = dir[0] + r;
            int col = dir[1] + c;
            if(dfs(row, col, id + 1, board, word)){
                result = true;
            }
        }
        board[r][c] = word.charAt(id);
        return result;
    }
}

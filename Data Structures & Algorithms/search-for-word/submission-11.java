class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(word.charAt(0) == board[i][j]){
                    boolean result = dfs(i, j, board, 0, word);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, char[][] board, int id, String word){
        if(id == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c] || word.charAt(id) != board[r][c]){
            return false;
        }
        

        visited[r][c] = true;
        boolean result = false;

        for(int[] d : directions){
            int row = d[0] + r;
            int col = d[1] + c;
            if(dfs(row, col, board, id + 1, word)){
                result = true;
                break;
            }
        }

        visited[r][c] = false;
        return result;
    }
}

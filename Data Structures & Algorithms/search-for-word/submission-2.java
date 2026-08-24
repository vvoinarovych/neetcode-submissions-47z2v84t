class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(bt(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean bt(char[][] board, String word, int r, int c, int id){
        if(id == word.length()){
            return true;
        }
        if(c < 0 || r < 0 || r >= board.length || c >= board[0].length || word.charAt(id) != board[r][c] || board[r][c] == '#'){
            return false;
        }
        
        board[r][c] = '#';
        boolean result = bt(board, word, r + 1, c, id + 1) ||
                         bt(board, word, r - 1, c, id + 1) ||
                         bt(board, word, r, c + 1, id + 1) ||
                         bt(board, word, r, c - 1, id + 1);
        board[r][c] = word.charAt(id);
        return result;
    }
}

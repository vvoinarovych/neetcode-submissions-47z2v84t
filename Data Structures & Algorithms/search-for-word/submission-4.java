class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(isValid(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, String word, int id, int r, int c){
        if(id == word.length()) return true;

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(id) || board[r][c] == '@') return false;
        
        
        board[r][c] = '@';
        boolean result = isValid(board, word, id + 1, r + 1, c) ||
                         isValid(board, word, id + 1, r - 1, c) ||
                         isValid(board, word, id + 1, r, c + 1) ||
                         isValid(board, word, id + 1, r, c - 1);
        board[r][c] = word.charAt(id);
        return result;
    }
}

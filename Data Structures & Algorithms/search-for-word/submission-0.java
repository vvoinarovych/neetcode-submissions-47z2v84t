class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isValid(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, String word, int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
            || board[row][col] != word.charAt(i) || board[row][col] == '#') {
            return false;
        }

        board[row][col] = '#';
        boolean result = isValid(board, word, row + 1, col, i+1) || 
                         isValid(board, word, row - 1, col, i+1) || 
                         isValid(board, word, row, col + 1, i+1) || 
                         isValid(board, word, row, col - 1, i+1);
        board[row][col] = word.charAt(i);        
        return result;
    }
}

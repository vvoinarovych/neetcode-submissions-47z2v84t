class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> sqrs = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                String key = "r" + i / 3 + 'c' + j / 3;
                if(rows.computeIfAbsent(i, v-> new HashSet<>()).contains(board[i][j]) ||
                   cols.computeIfAbsent(j, v-> new HashSet()).contains(board[i][j]) ||
                   sqrs.computeIfAbsent(key, v-> new HashSet()).contains(board[i][j]) ){
                    return false;
                   }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                sqrs.get(key).add(board[i][j]);
            }
        }
        return true;
    }
}

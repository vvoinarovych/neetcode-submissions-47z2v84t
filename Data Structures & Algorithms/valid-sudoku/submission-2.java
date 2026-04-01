class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> sq = new HashMap<>();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.'){
                    continue;
                }
                String sqkey = "row"+r/3+"col"+c/3;
                if(rows.computeIfAbsent(r, v -> new HashSet<>()).contains(board[r][c]) ||
                   cols.computeIfAbsent(c, v -> new HashSet<>()).contains(board[r][c]) ||
                   sq.computeIfAbsent(sqkey, v -> new HashSet<>()).contains(board[r][c])
                ){
                    return false;
                }                
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                sq.get(sqkey).add(board[r][c]);
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> sq = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                String key = "row" + i/3 + "col" + j/3;

                if(
                    rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                    cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                    sq.computeIfAbsent(key, k -> new HashSet<>()).contains(board[i][j])
                    ){
                        return false;
                    }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                sq.get(key).add(board[i][j]);
            }
        }
        return true;
    }
}

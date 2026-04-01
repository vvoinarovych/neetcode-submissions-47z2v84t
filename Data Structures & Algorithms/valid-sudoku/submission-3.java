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
                char num = board[r][c];
                String key = "r" + r/3 + "c" + c/3;
                if(rows.computeIfAbsent(r, v -> new HashSet<>()).contains(num) ||
                    cols.computeIfAbsent(c, v -> new HashSet<>()).contains(num) ||
                    sq.computeIfAbsent(key, v -> new HashSet<>()).contains(num)){
                        return false;
                    }
            rows.get(r).add(num);
            cols.get(c).add(num);
            sq.get(key).add(num);
            }
        }
        return true;
    }
}

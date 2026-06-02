class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> sqr = new HashMap<>();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.') continue;
                char ch = board[r][c];
                String sq = "r" + r / 3 + "c" + c / 3;
                if(row.computeIfAbsent(r, v -> new HashSet<>()).contains(ch) ||
                   col.computeIfAbsent(c, v -> new HashSet<>()).contains(ch) || 
                   sqr.computeIfAbsent(sq, v -> new HashSet<>()).contains(ch)){
                    return false;
                }
                row.get(r).add(ch);
                col.get(c).add(ch);
                sqr.get(sq).add(ch); 
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> sqr = new HashMap<>();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                String key = "row"+r/3+"col"+c/3;
                char number = board[r][c];
                if(number == '.'){
                    continue;
                }

                if(row.computeIfAbsent(r, k -> new HashSet<>()).contains(number) ||
                    col.computeIfAbsent(c, k -> new HashSet<>()).contains(number)||
                    sqr.computeIfAbsent(key, k -> new HashSet<>()).contains(number)){
                        return false;
                }

                row.get(r).add(number);
                col.get(c).add(number);
                sqr.get(key).add(number);
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> sqrs = new HashMap<>();

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char element = board[row][col];
                if(element == '.'){
                    continue;
                }
                String sq = "row" + row /3 + "col" + col/3;
                System.out.println(sq);
                if(rows.computeIfAbsent(row, v -> new HashSet<>()).contains(element) ||
                   cols.computeIfAbsent(col, v -> new HashSet<>()).contains(element) ||
                   sqrs.computeIfAbsent(sq, v -> new HashSet<>()).contains(element) ){
                        return false;
                }
                rows.get(row).add(element);
                cols.get(col).add(element);
                sqrs.get(sq).add(element);
            }
        }
        return true;        
    }
}

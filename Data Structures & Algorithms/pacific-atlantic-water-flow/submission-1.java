class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] po = new boolean[ROWS][COLS];
        boolean[][] ao = new boolean[ROWS][COLS];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < COLS; i++) {
            dfs(0, i, po, heights);
            dfs(ROWS - 1, i, ao, heights);
        }

        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, po, heights);
            dfs(i, COLS - 1, ao, heights);
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(po[i][j] && ao[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] grid){
        if(ocean[r][c]){
            return;
        }
        ocean[r][c] = true;
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];
            if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] >= grid[r][c]){
                dfs(row, col, ocean, grid);
            }
        }
    }
}

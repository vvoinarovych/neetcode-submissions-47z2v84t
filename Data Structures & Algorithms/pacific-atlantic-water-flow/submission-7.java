class Solution {
    int ROWS;
    int COLS;
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] ao = new boolean[ROWS][COLS];
        boolean[][] po = new boolean[ROWS][COLS];

        for (int i = 0; i < COLS; i++) {
            dfs(0, i, po, heights);
            dfs(ROWS - 1, i, ao, heights);
        }
        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, po, heights);
            dfs(i, COLS - 1, ao, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (ao[i][j] && po[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] grid){
        
        ocean[r][c] = true;
        for(int[] d : directions){
            int row = d[0] + r;
            int col = d[1] + c;
            if(row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] >= grid[r][c] && !ocean[row][col]){
                dfs(row,col,ocean,grid);
            }
        }
    }
}

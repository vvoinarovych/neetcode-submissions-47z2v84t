class Solution {
    int[][] directions = new int[][]{
        {1,0}, {-1, 0}, {0,1},{0,-1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] po = new boolean[ROWS][COLS];
        boolean[][] ao = new boolean[ROWS][COLS];

        for(int i = 0; i < COLS; i++){
            dfs(0, i, heights, po);
            dfs(ROWS -1 , i, heights, ao);
        }
        for(int i = 0; i < ROWS; i++){
            dfs(i, 0, heights,po);
            dfs(i, COLS-1, heights,ao);
        }
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < ROWS;i++){
            for(int j = 0; j < COLS; j++){
                if(po[i][j] && ao[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean){
        ocean[r][c] = true;
        int ROWS = heights.length;
        int COLS = heights[0].length;        
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr,nc,heights,ocean);
            }
        }
    }
}

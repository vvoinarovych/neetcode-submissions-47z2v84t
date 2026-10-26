class Solution {
    int ROW;
    int COL;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;
        boolean[][] po = new boolean[ROW][COL];
        boolean[][] ao = new boolean[ROW][COL];

        for (int i = 0; i < COL; i++) {
            dfs(0, i, po, heights);
            dfs(ROW - 1, i, ao, heights);
        }

        for (int i = 0; i < ROW; i++) {
            dfs(i, 0, po, heights);
            dfs(i, COL - 1, ao, heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (po[i][j] && ao[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        if (r < 0 || c < 0 || r >= ROW || c >= COL || ocean[r][c]) {
            return;
        }
        ocean[r][c] = true;
        for (int[] dir : directions) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (row >= 0 && col >= 0 && row < ROW && col < COL
                && heights[r][c] <= heights[row][col]) {
                dfs(row, col, ocean, heights);
            }
        }
    }
}

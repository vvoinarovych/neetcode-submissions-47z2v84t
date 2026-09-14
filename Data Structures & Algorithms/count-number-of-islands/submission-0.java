class Solution {
    int counter = 0;
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    counter++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return counter;
    }

    private void bfs(char[][] grid, int[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[row][col] == '0' || visited[row][col] == 1) {
            visited[row][col] = 1;
            return;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.push(new int[] {row, col});
        while (!q.isEmpty()) {
            int[] poll = q.pop();
            int r = poll[0];
            int c = poll[1];
            visited[r][c] = 1;
            if (r < rows && c + 1 < cols && visited[r][c + 1] != 1) {
                bfs(grid, visited, r, c + 1);
            }
            if (r < rows && c - 1 < cols && c - 1 >= 0 && visited[r][c - 1] != 1) {
                bfs(grid, visited, r, c - 1);
            }

            if (r + 1 < rows && c < cols && visited[r + 1][c] != 1) {
                bfs(grid, visited, r + 1, c);
            }
            if (r - 1 < rows && c < cols && r - 1 >= 0 && visited[r - 1][c] != 1) {
                bfs(grid, visited, r - 1, c);
            }
        }
    }
}

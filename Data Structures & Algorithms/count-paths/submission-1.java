class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        cache[0][0] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                int left = j > 0 ? cache[i][j - 1] : 0;
                int top =  i > 0 ? cache[i - 1][j] : 0;
                cache[i][j] = left + top;
            }
        }
        return cache[m - 1][n - 1];
    }
}

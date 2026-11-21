class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] cache = new Integer[m][n];
        dp(0,0,cache);
        return dp(m-1,n-1,cache);
    }

    private int dp(int r, int c, Integer[][] cache){
        if(r == 0 && c == 0){
            return 1;
        }
        if(r < 0 || c < 0){
            return 0;
        }
        if(cache[r][c] != null){
            return cache[r][c];
        }
        cache[r][c] = dp(r-1,c,cache) + dp(r,c-1, cache);
        return cache[r][c];
    }
}

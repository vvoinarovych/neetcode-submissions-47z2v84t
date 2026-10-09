class Solution {
    public int uniquePaths(int m, int n) {
        return rec(m-1, n-1, new Integer[m][n]);
    }

    private int rec(int r, int c, Integer[][] cache){
        if(r == 0 && c == 0){
            return 1;
        }
        if(r < 0 || c < 0){
            return 0;
        }
        if(cache[r][c] != null){
            return cache[r][c];
        }
        int result = rec(r - 1, c, cache) + rec(r, c - 1, cache);
        cache[r][c] = result;
        return cache[r][c];
    }
}

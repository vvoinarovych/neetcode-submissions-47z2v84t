class Solution {
    public int uniquePaths(int m, int n) {
        return rec(m - 1, n - 1, new Integer[m][n]);
    }

    private int rec(int m, int n, Integer[][] cache){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }
        if(cache[m][n] != null){
            return cache[m][n];
        }

        int result = rec(m - 1, n, cache) + rec(m, n - 1, cache);
        cache[m][n] = result;
        return result;
    }
}

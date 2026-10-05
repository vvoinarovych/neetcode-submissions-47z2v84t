class Solution {    
    public int uniquePaths(int m, int n) {        
        return rec(m - 1, n - 1, new Integer[m][n]);
    }
    //return number of unique ways to reach given coords
    private int rec(int r, int c, Integer[][] cache){
        if(r < 0 || c < 0){
            return 0;
        }
        if(r == 0 && c == 0) return 1;
        if(cache[r][c] != null) return cache[r][c];

        //result - add number of ways to reach previous cells (top | left from this one)
        
        int top = rec(r - 1, c, cache);
        int left = rec(r, c - 1, cache);
        cache[r][c] = top + left;
        return cache[r][c];
    }
}

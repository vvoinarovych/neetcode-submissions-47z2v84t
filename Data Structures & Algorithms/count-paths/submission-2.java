class Solution {
    public int uniquePaths(int m, int n) {
        return rec(m - 1, n - 1, new Integer[m][n]);
    }
    //qty of ways to get to point(i, j)
    private int rec(int i, int j, Integer[][] memo){
        //only one way to get to starting point
        if(i == 0 && j == 0){
            return 1;
        }
        //out of borders is invalid so safe to return 0
        if(i < 0 || j < 0){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        int top = rec(i - 1, j, memo);
        int left = rec(i, j - 1, memo);

        //sum of ways to get to previous cell
        memo[i][j] = top + left;

        return memo[i][j];
    }
}

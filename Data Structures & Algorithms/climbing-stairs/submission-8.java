class Solution {
    public int climbStairs(int n) {
        int prev2 = 1;
        int prev1 = 1;

        for(int i = 1; i < n; i++){
            int now = prev1 + prev2;
            prev2 = prev1;
            prev1 = now;
        }
        return prev1;
    }
}

class Solution {
    int invalid;
    public int coinChange(int[] coins, int amount) {
        invalid = amount + 1;
        Integer[] memo = new Integer[amount + 1];
        int res = rec(amount, coins, memo);
        
        return res > amount ? -1 : res;
    }

    private int rec(int sum, int[] coins, Integer[] memo){
        if(sum <= 0) return 0;
        if(memo[sum] != null) return memo[sum];
        int result = invalid;
        for(int c : coins){
            if(sum - c >= 0){
                result = Math.min(result, rec(sum - c, coins, memo) + 1);
            }
            
        }
        memo[sum] = result;
        return memo[sum];        
    }
}

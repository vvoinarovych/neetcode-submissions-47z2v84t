class Solution {
    int max;
    public int coinChange(int[] coins, int amount) {
        max = amount + 1;
        int result = rec(amount, coins, new Integer[amount + 1]);
        return result == max ? -1 : result;
    }

    private int rec(int amount, int[] coins, Integer[] cache){
        if(amount == 0){
            return 0;
        }
        if(cache[amount] != null){
            return cache[amount];
        }
        int result = max;
        for(int c : coins){
            if(amount - c >= 0){
                result = Math.min(result, rec(amount - c, coins, cache) + 1);
            }
        }
        cache[amount] = result;
        return result;
    }
}

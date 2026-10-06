class Solution {
    int guard;
    public int coinChange(int[] coins, int amount) {
        guard = amount + 1;
        Integer[] cache = new Integer[amount + 1];
        int result = rec(amount, coins, cache);
        
        return result == guard ? -1 : result;
    }

    //return how many coins needed to return given amount
    private int rec(int amount, int[] coins, Integer[] cache){
        if(amount == 0){
            return 0;
        }
        if(cache[amount] != null){
            return cache[amount];
        }
        int result = guard;
        for(int c : coins){
            if(amount - c >= 0){
                result = Math.min(result, rec(amount - c, coins, cache) + 1);
            }
        }
        cache[amount] = result;
        return cache[amount];
    }
}

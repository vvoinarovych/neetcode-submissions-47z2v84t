class Solution {
    int[] coins;
    Integer[] cache;
    int cap;
    public int coinChange(int[] coins, int amount) {
        this.cap = amount + 1;
        this.coins = coins;
        this.cache = new Integer[amount + 1];
        int result = rec(amount);
        return result == cap ? -1 : result;
    }
    //return minimum coins needed to get given amount
    private int rec(int amount){
        if(amount == 0){
            return 0;
        }
        if(cache[amount] != null){
            return cache[amount];
        }

        int result = cap;
        for(int c : coins){
            if(amount - c >= 0){
                result = Math.min(result, rec(amount - c) + 1);
            }
        }
        cache[amount] = result;
        return result;
    }
}

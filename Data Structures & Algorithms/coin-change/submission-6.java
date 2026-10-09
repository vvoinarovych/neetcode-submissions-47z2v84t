class Solution {
    int inf;
    public int coinChange(int[] coins, int amount) {
        inf = amount + 1;
        int rec = rec(coins, amount, new Integer[amount + 1]);
        return rec == inf ? - 1 : rec;
    }

    private int rec(int[] coins, int amount, Integer[] cache){
        if(amount == 0){
            return 0;
        }
        if(cache[amount] != null){
            return cache[amount];
        }
        int result = inf;
        for(int c : coins){
            if(amount - c >= 0){
                result = Math.min(result, rec(coins, amount - c, cache) + 1);
            }
        }
        cache[amount] = result;
        return cache[amount];
    }
}

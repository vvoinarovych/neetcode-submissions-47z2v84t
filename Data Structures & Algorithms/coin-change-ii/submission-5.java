class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] cache = new Integer[n][amount + 1];
        return rec(0, amount, coins, cache);
    }

    private int rec(int id, int amount, int[] coins, Integer[][] cache){
        if(amount == 0){
            return 1;
        }
        if(amount < 0 || id == coins.length){
            return 0;
        }
        if(cache[id][amount] != null){
            return cache[id][amount];
        }
        int ways = 0;
        ways += rec(id, amount - coins[id], coins, cache);
        ways += rec(id + 1, amount, coins, cache);

        cache[id][amount] = ways;
        return ways;        
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        return rec(0, amount, coins, new Integer[coins.length][amount + 1]);
    }

    private int rec(int id, int amount,  int[] coins, Integer[][] cache){
        if(amount == 0){
            return 1;
        }
        if(amount < 0 || id == coins.length){
            return 0;
        }
        if(cache[id][amount] != null){
            return cache[id][amount];
        }
        
        int take = rec(id, amount - coins[id], coins,cache);
        int skip = rec(id + 1, amount, coins, cache);
        int result = take + skip;
        cache[id][amount] = result;
        return result;
    }
}

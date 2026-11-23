class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] cache = new Integer[amount + 1][coins.length];
        return rec(amount, 0, coins, cache);
    }

    //return number of combinations to make given amount
    private int rec(int amount, int id, int[] coins, Integer[][] cache){
        if(amount == 0){
            return 1;
        }
        if(amount < 0 || id == coins.length){
            return 0;
        }
        if(cache[amount][id] != null){
            return cache[amount][id];
        }

        int take = rec(amount - coins[id], id, coins, cache);
        int skip = rec(amount, id + 1, coins, cache);
        int result = take + skip;
        cache[amount][id] = result;

        return result;
    }
}

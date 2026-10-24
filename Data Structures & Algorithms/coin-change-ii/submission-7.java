class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] cache = new Integer[amount + 1][coins.length];
        return count(amount, 0, coins, cache);
    }

    private int count(int amount, int id, int[] coins, Integer[][] cache){
        if(amount == 0){
            return 1;
        }
        if(amount < 0 || id == coins.length){
            return 0;
        }
        if(cache[amount][id] != null){
            return cache[amount][id];
        }
        int take = count(amount - coins[id], id, coins, cache);
        int dontTake = count(amount, id + 1, coins, cache);
        int result = take + dontTake;
        cache[amount][id] = result;
        return result;
    }
}

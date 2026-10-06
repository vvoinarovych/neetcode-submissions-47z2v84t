class Solution {
    public int change(int amount, int[] coins) {
        return rec(0, amount, coins, new Integer[coins.length ][amount + 1]);
    }

    // return number of ways to gather given amount
    private int rec(int id, int amount, int[] coins, Integer[][] cache) {
        if (amount == 0) {
            return 1;
        }
        if(id == coins.length) return 0;
        if (cache[id][amount] != null) {
            return cache[id][amount];
        }

        int result = rec(id + 1, amount, coins, cache);

        if (amount - coins[id] >= 0) {
            result += rec(id, amount - coins[id], coins, cache);
        }
        cache[id][amount] = result;
        return result;
    }
}

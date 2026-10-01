class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, amount + 1);
        cache[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    cache[i] = Math.min(cache[i - c] + 1, cache[i]);
                }
            }
        }
        return cache[amount] > amount ? -1 : cache[amount];
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 0;

        for(int i = 2; i <= n; i++){
            cache[i] = Math.min(cache[i - 1] + cost[i - 1], cache[i - 2] + cost[i - 2]);
        }
        return cache[n];
    }
}

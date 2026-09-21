class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length + 1];
        cache[0] = 0;
        cache[1] = 0;

        for(int i = 2; i <= cost.length; i++){
            cache[i] = Math.min(cost[i-1] + cache[i-1], cost[i-2] + cache[i-2]);
        }
        return cache[cost.length];
    }
}

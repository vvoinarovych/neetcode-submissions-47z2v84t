class Solution {
    public int minCostClimbingStairs(int[] cost) {       
        int[] cache = new int[cost.length + 1];       
        Arrays.fill(cache, -1);
        
        return calc(cost.length, cache, cost);
    }

    private int calc(int h, int[] cache, int[] cost){
        if(h == 0 || h == 1) return 0;
        if(cache[h] != -1) return cache[h];
        cache[h] = Math.min(cost[h - 1] + calc(h-1, cache,cost), cost[h-2] + calc(h-2, cache,cost));
        return cache[h];
    }
}

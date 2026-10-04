class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] cache = new Integer[cost.length + 1];
        return rec(cost.length, cost, cache);
    }
    
    private int rec(int step, int[] cost, Integer[] cache){
        if(step == 0) return 0;
        if(step == 1) return 0;
        if(cache[step] != null) return cache[step];
        int step1 = rec(step - 1, cost, cache) + cost[step - 1];
        int step2 = rec(step - 2, cost, cache) + cost[step - 2];
        cache[step] = Math.min(step1, step2);
        return cache[step];
    }
}

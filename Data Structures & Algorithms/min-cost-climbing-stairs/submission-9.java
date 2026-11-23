class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 0;

        for(int i = 2; i <= n; i++){
            steps[i] = Math.min(steps[i - 1] + cost[i - 1], steps[i - 2] + cost[i - 2]);
        }
        return steps[n];
    }
}

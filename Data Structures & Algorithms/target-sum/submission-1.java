class Solution {
    int max;
    public int findTargetSumWays(int[] nums, int target) {
        max = Arrays.stream(nums).sum();
        int n = nums.length;
        Integer[][] cache = new Integer[n + 1][max * 2 + 1];
        return rec(n, target, nums, cache);
    }

    private int rec(int id, int sum, int[] nums, Integer[][] cache) {
        if(Math.abs(sum) > max){
            return 0;
        }
        if(id == 0) return sum == 0 ? 1 : 0;
        if(cache[id][sum + max] != null){
            return cache[id][sum + max];
        }

        int result = rec(id - 1, sum - nums[id - 1], nums, cache) + rec(id - 1, sum + nums[id - 1], nums, cache);
        cache[id][sum + max] = result;
        return cache[id][sum + max];
    }
}

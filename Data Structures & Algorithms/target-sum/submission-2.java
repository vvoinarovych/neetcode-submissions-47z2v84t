class Solution {
    int cap;
    public int findTargetSumWays(int[] nums, int target) {
        cap = Arrays.stream(nums).sum();
        int n = nums.length;
        Integer[][] cache = new Integer[n][cap * 2 + 1];
        return rec(n - 1, target, nums, cache); 
    }

    private int rec(int id, int target, int[] nums, Integer[][] cache){
        if(Math.abs(target) > cap){
            return 0;
        }
        if(id < 0){
            return target == 0 ? 1 : 0;
        }
        if(cache[id][target + cap] != null){
            return cache[id][target + cap];
        }
        cache[id][target + cap] = rec(id - 1, target + nums[id], nums, cache) + rec(id - 1, target - nums[id], nums, cache);
        return cache[id][target + cap];
    }
}

class Solution {
    int cap;
    public int findTargetSumWays(int[] nums, int target) {
        cap = Arrays.stream(nums).sum();
        return rec(0, nums, target, new Integer[nums.length + 1][2 * cap + 1]);
    }

    private int rec(int id, int[] nums, int target, Integer[][] cache){
        if(Math.abs(target) > cap){
            return 0;
        }
        if(id == nums.length){
            return target == 0 ? 1 : 0;
        }
        if(cache[id][target + cap] != null){
            return cache[id][target + cap];
        }
        int add = rec(id + 1, nums, target - nums[id], cache);
        int sub = rec(id + 1, nums, target + nums[id], cache);
        int result = add + sub;
        cache[id][target + cap] = result;
        return result;
    }
}

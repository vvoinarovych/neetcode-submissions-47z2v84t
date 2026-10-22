class Solution {
    int max;
    public int findTargetSumWays(int[] nums, int target) {
        max = Arrays.stream(nums).sum();
        int n = nums.length;
        Integer[][] cache = new Integer[n][max * 2 + 1];
        return rec(0,0, target,nums,cache);
    }

    private int rec(int id, int sum, int target, int[] nums, Integer[][] cache){
        if(Math.abs(sum) > max){
            return 0;
        }
        if(id == nums.length){
            return sum == target ? 1 : 0;
        }
        if(cache[id][sum + max] != null){
            return cache[id][sum + max];
        }
        int add = rec(id + 1, sum + nums[id], target, nums, cache);
        int sub = rec(id + 1, sum - nums[id], target, nums, cache);
        int result = add + sub;
        cache[id][sum + max] = result;
        return result;
    }
}

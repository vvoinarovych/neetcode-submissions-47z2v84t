class Solution {
    int max;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        max = Arrays.stream(nums).sum();
        Integer[][] cache = new Integer[n][max * 2 + 1];
        return rec(0, target, nums, cache);
    }

    private int rec(int i, int target, int[] nums, Integer[][] cache){
        if(Math.abs(target) > max){
            return 0;
        }
        if(i == nums.length){
            return target == 0 ? 1 : 0;
        }
        if(cache[i][target + max] != null){
            return cache[i][target + max];
        }
        int result = rec(i + 1, target - nums[i], nums, cache) + rec(i + 1, target + nums[i], nums, cache);
        cache[i][target + max] = result;
        return result;
    }
}

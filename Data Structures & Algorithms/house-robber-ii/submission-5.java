class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] rf = Arrays.copyOfRange(nums, 1, nums.length);
        int[] rl = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(solve(rf), solve(rl));
    }

    private int solve(int[] nums){
        int[] cache = new int[nums.length + 1];
        cache[0] = 0;
        cache[1] = nums[0];
        for(int i = 2; i < cache.length; i++){
            cache[i] = Math.max(cache[i - 1], cache[i - 2] + nums[i - 1]);
        }
        return cache[cache.length - 1];
    }
}

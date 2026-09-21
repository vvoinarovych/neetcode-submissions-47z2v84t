class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length + 1];
        cache[0] = 0;
        cache[1] = nums[0];
        for(int i = 2; i < cache.length; i++){
            cache[i] = Math.max(cache[i-1], cache[i-2] + nums[i-1]);
        }
        return cache[cache.length - 1];
    }
}

class Solution {
    public int rob(int[] nums) {
        // nums:  1,1,3,3
        // cache: 0,0,0,0,0
        int[] cache = new int[nums.length + 1];
        cache[0] = 0;
        cache[1] = nums[0];

        for(int i = 2; i <= nums.length; i++){
            cache[i] = Math.max(cache[i - 1], nums[i - 1] + cache[i - 2]);
        }
        return cache[cache.length - 1];
    }
}

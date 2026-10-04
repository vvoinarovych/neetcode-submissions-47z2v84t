class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int n = nums.length;
        int[] cache = new int[n];
        cache[0] = nums[0];
        cache[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            cache[i] = Math.max(nums[i] + cache[i - 2], cache[i - 1]);            
        }
        return cache[n - 1];
    }
}

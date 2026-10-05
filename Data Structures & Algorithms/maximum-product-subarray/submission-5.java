class Solution {
    public int maxProduct(int[] nums) {
        int[][] cache = new int[nums.length][2];
        cache[0] = new int[]{nums[0], nums[0]};
        int result = nums[0];
        for(int i = 1; i < cache.length; i++){
            int prevMax = cache[i - 1][1] * nums[i];
            int prevMin = cache[i - 1][0] * nums[i];
            int min = Math.min(nums[i], Math.min(prevMax, prevMin));
            int max = Math.max(nums[i], Math.max(prevMax, prevMin));
            cache[i][0] = min;
            cache[i][1] = max;
            result = Math.max(result, cache[i][1]);
        }
        return result;
    }
}

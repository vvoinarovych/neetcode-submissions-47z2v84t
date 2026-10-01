class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][2];
        cache[0] = new int[]{nums[0],nums[0]};
        int result = cache[0][0];

        for(int i = 1; i < n; i++){
            int prevMax = cache[i - 1][0] * nums[i];
            int prevMin = cache[i - 1][1] * nums[i];
            
            cache[i][0] = Math.max(nums[i], Math.max(prevMax, prevMin));
            cache[i][1] = Math.min(nums[i], Math.min(prevMin, prevMax));

            result = Math.max(result, cache[i][0]);
        }
        return result;
    }
}

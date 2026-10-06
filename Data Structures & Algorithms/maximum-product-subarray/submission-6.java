class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][2];
        cache[0] = new int[]{nums[0], nums[0]};
        int result = nums[0];
        for(int i = 1; i < n; i++){
            int s = nums[i] * cache[i - 1][0];
            int b = nums[i] * cache[i - 1][1];
            cache[i][0] = Math.min(nums[i], Math.min(s,b));
            cache[i][1] = Math.max(nums[i], Math.max(s,b));

            result = Math.max(result, cache[i][1]);                    
        }
        return result;
    }
}

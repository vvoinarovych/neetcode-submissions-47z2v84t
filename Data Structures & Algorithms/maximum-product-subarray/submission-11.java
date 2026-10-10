class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][2];
        cache[0] = new int[]{nums[0], nums[0]};
        int result = nums[0];

        for(int i = 1; i < n; i++){
            int val = nums[i];
            int max = Math.max(cache[i - 1][0] * val, cache[i - 1][1] * val);
            int min = Math.min(cache[i - 1][0] * val, cache[i - 1][1] * val);

            cache[i][0] = Math.max(max, val);
            cache[i][1] = Math.min(min, val);

            result = Math.max(cache[i][0], result);
        }
        return result;
    }
}

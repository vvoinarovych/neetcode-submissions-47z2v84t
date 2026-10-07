class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int best = nums[0];
        int[][] cache = new int[n][2];
        cache[0][0] = nums[0];
        cache[0][1] = nums[0];

        for(int i = 1; i < nums.length; i++){
            int val = nums[i];
            int min = Math.min(cache[i - 1][0] * val, cache[i - 1][1] * val);
            int max = Math.max(cache[i - 1][0] * val, cache[i - 1][1] * val);
            cache[i][1] = Math.max(val, Math.max(min, max));
            cache[i][0] = Math.min(val, Math.min(min, max));
            best = Math.max(best, cache[i][1]);
        }
        return best;
    }
}

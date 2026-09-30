class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][2];
        cache[0] = new int[]{nums[0],nums[0]};
        int result = nums[0];        
        for(int i = 1; i < n; i++){
            int val = nums[i];
            int a = cache[i - 1][0] * val;
            int b = cache[i - 1][1] * val;
            cache[i][0] = Math.max(val, Math.max(a,b));
            cache[i][1] = Math.min(val, Math.min(a,b));

            result = Math.max(result, cache[i][0]);
        }
        return result;
    }    
}

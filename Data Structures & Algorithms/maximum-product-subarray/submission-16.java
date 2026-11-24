class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] products = new int[n][2];
        products[0][0] = nums[0]; //0 - min
        products[0][1] = nums[0]; //1 - max
        int result = nums[0];
        for(int i = 1; i < n; i++){
            int min = products[i - 1][0] * nums[i];
            int max = products[i - 1][1] * nums[i];
            int start = nums[i];

            products[i][0] = Math.min(start, Math.min(min, max));
            products[i][1] = Math.max(start, Math.max(min, max));
            result = Math.max(result, products[i][1]);
        }
        return result;
    }

    
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int best = 1;
        int[] cache = new int[n];
        Arrays.fill(cache, 1);
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j ++){
                if(nums[j] < nums[i]){
                    cache[i] = Math.max(cache[i], cache[j] + 1);                    
                }
                best = Math.max(cache[i], best);
            }
        }
        return best;
    }
}

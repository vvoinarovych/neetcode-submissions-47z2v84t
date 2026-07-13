class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums.length >= 1 ? nums[0] : 0;
        int current = 0;
        for(int i = 0; i < nums.length; i++){            
            if(current < 0){
                current = 0;
            }
            current = current + nums[i];
            max = Math.max(max, current);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = 0;
        for(int num : nums){
            if(current < 0){
                current = 0;
            }
            current += num;
            max = Math.max(max, current);
        }
        return max;
    }
}

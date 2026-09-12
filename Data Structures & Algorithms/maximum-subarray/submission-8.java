class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;

        for(int num : nums){
            cur += num;
            max = Math.max(max, cur);
            if(cur < 0){
                cur = 0;
            }
            
        }
        return max;
    }
}

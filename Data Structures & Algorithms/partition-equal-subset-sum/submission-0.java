class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        return rec(0, sum / 2, nums);
    }

    private boolean rec(int start, int sum, int[] nums){
        if(sum == 0) return true;
        if(sum < 0) return false;
        for(int i = start; i < nums.length; i++){
            if(rec(i + 1, sum - nums[i], nums)){
                return true;
            }
        }
        return false;
    }
}

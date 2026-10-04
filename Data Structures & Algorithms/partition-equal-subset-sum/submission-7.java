class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n][sum / 2 + 1];
        return rec(nums, 0, sum / 2, memo);
    }

    private boolean rec(int[] nums, int id, int sum, Boolean[][] memo) {
        if (sum == 0) {
            return true;
        }
        if (id == nums.length) {
            return false;
        }        
        if (memo[id][sum] != null) return memo[id][sum];

        boolean res = false;
        if(sum - nums[id] >= 0){
            res = rec(nums,id+1,sum-nums[id],memo);
        }
        if(!res){
            res = rec(nums, id + 1, sum, memo);
        }
        memo[id][sum] = res;
        return memo[id][sum];
    }
}

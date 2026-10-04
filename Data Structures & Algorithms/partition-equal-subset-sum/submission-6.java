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
        if (id == nums.length) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (memo[id][sum] != null) return memo[id][sum];

        for (int i = id; i < nums.length; i++) {
            if (sum - nums[i] >= 0) {
                if (rec(nums, i + 1, sum - nums[i],memo)) {
                    memo[id][sum] = true;
                    return true;
                }
            }
        }
        return false;
    }
}

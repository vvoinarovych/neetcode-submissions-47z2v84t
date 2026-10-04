class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        return rec(nums, 0, sum / 2);
    }

    private boolean rec(int[] nums, int id, int sum) {
        if (sum == 0)
            return true;
        for (int i = id; i < nums.length; i++) {
            if (sum - nums[i] >= 0) {
                if (rec(nums, i + 1, sum - nums[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}

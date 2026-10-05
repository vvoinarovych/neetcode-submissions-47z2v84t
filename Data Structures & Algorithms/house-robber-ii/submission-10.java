class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] noFrist = Arrays.copyOfRange(nums, 1, nums.length);
        int[] noLast = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(rec(noFrist.length - 1, noFrist, new Integer[noFrist.length + 1]),
            rec(noLast.length - 1, noLast, new Integer[noLast.length + 1]));
    }

    // return most money stolen for houses ending in i
    private int rec(int i, int[] nums, Integer[] memo) {
        if (i < 0){
            return 0;
        }
            
        if (memo[i] != null){
            return memo[i];
        }
            
        memo[i] = Math.max(rec(i - 1, nums, memo), rec(i - 2, nums, memo) + nums[i]);
        return memo[i];
    }
}

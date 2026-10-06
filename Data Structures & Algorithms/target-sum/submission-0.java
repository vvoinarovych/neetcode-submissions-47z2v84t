class Solution {
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = Arrays.stream(nums).sum();
        return rec(n, nums, target, new Integer[n + 1][2 * sum + 1]);
    }

    // return number of possible sums for first id  numbers
    private int rec(int id, int[] nums, int target, Integer[][] cache) {
        if(Math.abs(target) > sum) return 0;
        if(id == 0) return target == 0 ? 1 : 0;
        if (cache[id][target + sum] != null) {
            return cache[id][target + sum];
        }

        int minus = rec(id - 1, nums, target + nums[id - 1], cache);
        int plus = rec(id - 1, nums, target - nums[id - 1], cache);
        int result = minus + plus;
        cache[id][target + sum] = result;

        return cache[id][target + sum];
    }
}

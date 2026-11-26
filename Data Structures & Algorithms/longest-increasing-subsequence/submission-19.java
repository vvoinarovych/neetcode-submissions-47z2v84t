class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, rec(i, nums, new Integer[nums.length + 1]));
        }
        return max;
    }

    private int rec(int id, int[] nums, Integer[] cache) {
        if (cache[id] != null) {
            return cache[id];
        }
        int result = 1;
        for (int i = 0; i < id; i++) {
            if (nums[id] > nums[i]) {
                result = Math.max(result, rec(i, nums, cache) + 1);
            }
        }
        cache[id] = result;
        return result;
    }
}

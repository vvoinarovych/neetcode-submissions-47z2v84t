class Solution {
    public int rob(int[] nums) {
        return rec(nums.length, nums, new Integer[nums.length + 1]);
    }

    private int rec(int id, int[] nums, Integer[] cache){
        if(id <= 0){
            return 0;
        }
        if(cache[id] != null){
            return cache[id];
        }
        int result = Math.max(rec(id - 1, nums, cache), rec(id - 2, nums, cache) + nums[id - 1]);
        cache[id] = result;
        return result;
    }
}

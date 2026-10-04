class Solution {
    public int rob(int[] nums) {        
        Integer[] cache = new Integer[nums.length];
        return rec(nums.length - 1, nums, cache);
    }

    private int rec(int house, int[] nums, Integer[] cache){
        if(house < 0) return 0;
        if(cache[house] != null) return cache[house];

        int take = nums[house] + rec(house - 2, nums, cache);
        int dontTake = rec(house - 1, nums, cache);
        cache[house] = Math.max(take, dontTake);
        return cache[house];
    }
}

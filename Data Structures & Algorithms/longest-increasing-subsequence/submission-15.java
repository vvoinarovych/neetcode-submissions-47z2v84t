class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        Integer[] cache = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, rec(i, nums, cache));
        }
        return max;
    }

    private int rec(int id, int[] nums, Integer[] cache){
        // if(id == nums.length){
        //     return 1;
        // }
        if(cache[id] != null){
            return cache[id];
        }
        int result = 1;
        for(int i = 0; i < id; i ++){
            if(nums[i] < nums[id]){
                result = Math.max(result, rec(i,nums,cache) + 1);
            }
        }
        cache[id] = result;
        return result;
    }
}

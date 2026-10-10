class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[] cache = new Integer[n];
        int result = 1;

        for(int i = 0; i < nums.length; i++){
            result = Math.max(result, rec(i, nums, cache));
        }
        return result;
    }

    private int rec(int id, int[] nums, Integer[] cache){
        if(id == 0){
            return 1;
        }
        if(cache[id] != null){
            return cache[id];
        }

        int result = 1;
        for(int i = 0; i < id; i++){
            if(nums[i] < nums[id]){
                result = Math.max(result, rec(i, nums, cache) + 1);
            }
        }
        cache[id] = result;
        return cache[id];
    }
}

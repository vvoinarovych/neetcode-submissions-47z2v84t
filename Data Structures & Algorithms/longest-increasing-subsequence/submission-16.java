class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        for(int i = 1; i < n; i++){
            max = Math.max(max, count(i, nums, new Integer[n]));
        }
        return max;
    }

    private int count(int id, int[] nums, Integer[] cache){
        
        if(cache[id] != null){
            return cache[id];
        }
        int result = 1;
        for(int i = 0; i < id; i++){
            if(nums[i] < nums[id]){
                result = Math.max(result, count(i, nums, cache) + 1);
            }
        }
        cache[id] = result;
        return result;
    }
}

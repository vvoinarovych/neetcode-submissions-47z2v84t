class Solution {    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[] cache = new Integer[n + 1];
        int best = 1;
        for(int i = 1; i <= n; i++){
            best = Math.max(best, rec(i,nums, cache));
        }
        return best;
    }
    //longest subsiquence from 0 to id-1
    private int rec(int id, int[] nums, Integer[] cache){
        if(id == 1){
            return 1;
        }
        if(cache[id] != null){
            return cache[id];
        }
        int result = 1;
        for(int i = 1; i < id; i++){
            if(nums[i-1] < nums[id - 1]){
                result = Math.max(result, rec(i, nums, cache) + 1);
            }            
        }        
        cache[id] = result;
        return cache[id];
    }
}

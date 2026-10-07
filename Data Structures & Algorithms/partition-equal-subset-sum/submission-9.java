class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        Boolean[][] cache = new Boolean[nums.length][sum / 2 + 1];
        boolean result = rec(nums.length - 1, sum / 2, nums, cache);
        return result;
    }

    private boolean rec(int id, int sum, int[] nums, Boolean[][] cache){
        if(sum == 0) return true;
        if((id < 0 && sum != 0) || sum < 0) return false;
        if(cache[id][sum] != null) return cache[id][sum];

        
        boolean take = rec(id - 1, sum - nums[id], nums, cache);
        boolean dontTake = rec(id - 1, sum, nums, cache);
        boolean result = take || dontTake;
        cache[id][sum] = result;
        return cache[id][sum];
    }
}

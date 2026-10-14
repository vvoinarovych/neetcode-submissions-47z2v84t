class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }
        Boolean[][] cache = new Boolean[nums.length][sum / 2 + 1];
        return rec(0, sum / 2, nums, cache);
    }

    private boolean rec(int id, int sum, int[] nums, Boolean[][] cache){
        if(sum == 0){
            return true;
        }
        if(id == nums.length || sum < 0){
            return false;
        }
        if(cache[id][sum] != null){
            return cache[id][sum];
        }
        boolean result = rec(id + 1, sum - nums[id], nums, cache) || rec(id + 1, sum, nums, cache);
        cache[id][sum] = result;
        return result;
    }
}

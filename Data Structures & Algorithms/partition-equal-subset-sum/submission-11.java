class Solution {
    int sum;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        sum = Arrays.stream(nums).sum();
        Boolean[][] cache = new Boolean[nums.length][sum];
        return rec(0, 0, nums, cache);
    }

    private boolean rec(int id, int localS, int[] nums, Boolean[][] cache){
        if(sum - localS == localS){
            return true;
        }
        if(id == nums.length || sum - localS < localS){
            return false;
        }
        if(cache[id][localS] != null){
            return cache[id][localS];
        }

        boolean take = rec(id + 1, localS + nums[id], nums, cache);
        boolean skip = rec(id + 1, localS, nums, cache);

        boolean result = take || skip;
        cache[id][localS] = result;
        return result;
    }
}

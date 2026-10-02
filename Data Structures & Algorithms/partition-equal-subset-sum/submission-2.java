class Solution {
    Boolean[][] cache;
    public boolean canPartition(int[] nums) {        
        int sum = Arrays.stream(nums).sum();
        cache = new Boolean[nums.length + 1][sum+1];
        if(sum % 2 != 0) return false;
        return rec(0, sum / 2, nums);
    }

    private boolean rec(int start, int sum, int[] nums){
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(cache[start][sum] != null) return cache[start][sum];
        for(int i = start; i < nums.length; i++){
            if(rec(i + 1, sum - nums[i], nums)){
                return true;
            }
        }
        cache[start][sum] = false;
        return false;
    }
}

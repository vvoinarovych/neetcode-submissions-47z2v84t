class Solution {
    int globalS;
    public int findTargetSumWays(int[] nums, int target) {
        globalS = Arrays.stream(nums).sum();
        Integer[][] cache = new Integer[nums.length + 1][globalS * 2 + 1];
        return rec(nums.length, target, nums, cache);
    }

    private int rec(int id, int sum, int[] nums, Integer[][] cache){
        if(Math.abs(sum) > globalS){
            return 0;
        }
        if(id == 0){
            return sum == 0 ? 1 : 0;
        }
        if(cache[id][sum + globalS] != null){
            return cache[id][sum + globalS];
        }

        int add = rec(id - 1, sum - nums[id  - 1], nums, cache);
        int sub = rec(id - 1, sum + nums[id - 1], nums, cache);
        int result = add + sub;
        cache[id][sum + globalS] = result;
        return result;
    }
}

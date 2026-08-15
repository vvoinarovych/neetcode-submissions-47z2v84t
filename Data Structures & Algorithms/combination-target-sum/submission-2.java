class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, target, subset,result);
        return result;
    }

    public void dfs(int[] nums, int id, int target, List<Integer> subset, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0) {
            return;
        }

        for(int i = id; i < nums.length; i++){
            if(target - nums[i] < 0) continue;
            subset.add(nums[i]);
            dfs(nums, i, target - nums[i], subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}

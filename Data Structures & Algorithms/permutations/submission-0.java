class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(nums, 0, sub, result, new HashSet<>());
        return result;
    }
    public void dfs(int[] nums, int id, List<Integer> sub, List<List<Integer>> result, Set<Integer> set){
        if(sub.size() == nums.length){
            result.add(new ArrayList<>(sub));
        }

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            sub.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, i + 1, sub, result, set);
            sub.remove(sub.size() - 1);
            set.remove(nums[i]);
        }
    }
}

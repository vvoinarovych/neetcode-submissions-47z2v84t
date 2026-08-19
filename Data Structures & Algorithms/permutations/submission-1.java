class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), new HashSet<>());
        return result;
    }

    public void dfs(int[] nums, List<Integer> sub, Set<Integer> set){
        if(nums.length == sub.size()){
            result.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            sub.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, sub, set);
            sub.remove(sub.size() - 1);
            set.remove(nums[i]);
        }
    }
}

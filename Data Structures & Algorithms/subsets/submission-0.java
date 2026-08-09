class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list, result);
        return result;
    }

    public void dfs (int[] nums, int id,List<Integer> list, List<List<Integer>> result){
        if(id >= nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[id]);
        dfs(nums, id + 1, list, result);

        list.remove(list.size() - 1);
        dfs(nums, id + 1, list, result);
    }
}

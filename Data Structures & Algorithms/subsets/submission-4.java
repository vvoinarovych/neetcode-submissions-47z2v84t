class Solution {
    List<List<Integer>> result = new ArrayList<>();    
    public List<List<Integer>> subsets(int[] nums) {
        bt(0, nums, new ArrayList<>());
        return result;
    }

    private void bt(int id, int[] nums, List<Integer> sub) {
        result.add(new ArrayList<>(sub));
        for(int i = id; i < nums.length; i++){
            sub.add(nums[i]);
            bt(i + 1, nums, sub);
            sub.remove(sub.size() - 1);
        }
    }
}

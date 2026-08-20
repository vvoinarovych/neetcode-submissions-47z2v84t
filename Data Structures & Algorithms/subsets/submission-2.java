class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        bt(nums, 0, new ArrayList<>());
        return result;
    }
    void bt(int[] nums, int id, List<Integer> sub){
        if(id == nums.length){
            result.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[id]);
        bt(nums, id + 1, sub);
        sub.remove(sub.size() - 1);
        bt(nums, id + 1, sub);
    }
}

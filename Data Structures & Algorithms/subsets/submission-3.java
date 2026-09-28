class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        bt(nums, 0, new ArrayList<>());
        return result;
    }

    private void bt(int[] nums, int id, List<Integer> sub){
        result.add(new ArrayList<>(sub));

        for(int i = id; i < nums.length; i++){
            sub.add(nums[i]);
            bt(nums, i + 1, sub);
            sub.remove(sub.size() - 1);
        }
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bt(0, nums, new ArrayList<>());
        return result;
    }

    private void bt(int id, int[] nums, List<Integer> sub){
        result.add(new ArrayList<>(sub));

        for(int i = id; i < nums.length; i++){
            if(i > id && nums[i] == nums[i - 1]) continue;
            sub.add(nums[i]);
            bt(i + 1, nums, sub);
            sub.remove(sub.size() - 1);
        }
    }
}

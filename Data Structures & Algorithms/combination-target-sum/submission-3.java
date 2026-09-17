class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        bt(nums, 0, target, new ArrayList<>());
        return result;
    }

    private void bt(int[] nums, int id, int target, List<Integer> sub){
        if(target == 0){
            result.add(new ArrayList<>(sub));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = id; i < nums.length; i++){
            if(target - nums[i] < 0){
                continue;
            }
            sub.add(nums[i]);
            bt(nums, i, target - nums[i], sub);
            sub.remove(sub.size() - 1);
        }
    }
}

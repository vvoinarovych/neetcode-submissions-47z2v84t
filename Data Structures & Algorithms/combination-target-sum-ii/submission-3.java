class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, 0, target, new ArrayList<>());
        return result;
    }
    public void bt(int[] nums, int id, int target, List<Integer> sub){
        if(target == 0){
            result.add(new ArrayList<>(sub));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = id; i < nums.length; i++){
            if(i > id && nums[i] == nums[i - 1]){
                continue;
            }
            if(target - nums[i] < 0){
                continue;
            }
            sub.add(nums[i]);
            bt(nums, i + 1, target - nums[i], sub);
            sub.remove(sub.size() - 1);
        }
    }
}

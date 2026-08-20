class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bt(nums, 0, new ArrayList<>());
        return result;
    }
    void bt(int[] nums, int id, List<Integer> sub){
        result.add(new ArrayList<>(sub));           
        
        for(int i = id; i < nums.length; i++){
            if(i > id && nums[i] == nums[i - 1]){
                continue;
            }
            sub.add(nums[i]);
            bt(nums, i + 1, sub);
            sub.remove(sub.size() - 1);
        }
    }
}

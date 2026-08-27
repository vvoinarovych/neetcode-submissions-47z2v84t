class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        bt(nums, new ArrayList<>());
        return result;
    }

    public void bt(int[] nums, List<Integer> sub){
        if(sub.size() == nums.length){
            result.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            sub.add(nums[i]);
            set.add(nums[i]);
            bt(nums, sub);
            sub.remove(sub.size() - 1);
            set.remove(nums[i]);
        }
    }
}

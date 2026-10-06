class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        bt(nums, new ArrayList<>());
        return result;
    }

    private void bt (int[] nums, List<Integer> sub){
        if(sub.size() == nums.length){
            result.add(new ArrayList<>(sub));
        }

        for(int num : nums){
            if(set.contains(num)) continue;
            sub.add(num);
            set.add(num);
            bt(nums, sub);
            sub.remove(sub.size() - 1);
            set.remove(num);
        }
    }
}

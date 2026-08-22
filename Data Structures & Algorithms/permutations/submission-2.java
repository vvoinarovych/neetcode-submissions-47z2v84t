class Solution {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        bt(nums,new ArrayList<>());
        return result;
    }

    void bt(int[] nums, ArrayList<Integer> sub){
        if(sub.size() == nums.length){
            result.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true){
                continue;
            }

            sub.add(nums[i]);
            visited[i] = true;
            bt(nums, sub);
            sub.remove(sub.size() - 1);
            visited[i] = false;
        }
    }
}

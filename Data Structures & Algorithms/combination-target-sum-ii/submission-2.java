class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    void dfs(int[] candidates, int id, int target, List<Integer> sub, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(sub));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = id; i < candidates.length; i++){
            if(i > id && candidates[i] == candidates[i - 1]){
                continue;
            }
            sub.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], sub, result);
            sub.remove(sub.size() - 1);
        }
    }
}

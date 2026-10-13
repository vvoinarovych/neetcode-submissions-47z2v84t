class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(0, candidates, target, new ArrayList<>());
        return result;
    }

    private void bt(int id, int[] candidates, int target, List<Integer> sub){
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
            bt(i + 1, candidates, target - candidates[i], sub);
            sub.remove(sub.size() - 1);
        }
    }
}

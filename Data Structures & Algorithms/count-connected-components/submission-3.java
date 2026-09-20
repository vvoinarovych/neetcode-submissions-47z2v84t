class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        int counter = 0;
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                counter++;
                dfs(i);
            }
        }
        return counter;
    }

    private void dfs(int node){
        if(visited.contains(node)) return;
        visited.add(node);
        for(int nb : map.get(node)){
            dfs(nb);
        }
    }
}

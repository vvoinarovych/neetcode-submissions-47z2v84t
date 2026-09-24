class Solution {
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i, adj);
                counter++;
            }
        }
        return counter;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        for(int nb : adj.get(node)){
            dfs(nb, adj);
        }
    }
}

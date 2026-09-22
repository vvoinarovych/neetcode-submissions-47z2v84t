class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        if(!dfs(0,-1)) return false;
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent){
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        for(int nb : adj.get(node)){
            if(nb == parent) continue;
            boolean result = dfs(nb, node);
            if(!result) return false;
        }
        return true;
    }
}

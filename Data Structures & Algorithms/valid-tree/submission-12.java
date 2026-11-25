class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        if(!dfs(0,-1,adj)){
            return false;
        }
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map){
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        
        for(int n : map.get(node)){
            if(n == parent){
                continue;
            }
            if(!dfs(n, node, map)){
                return false;
            }
        }
        return true;
    }
}

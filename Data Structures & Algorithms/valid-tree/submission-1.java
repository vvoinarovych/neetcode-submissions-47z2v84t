class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        if(!dfs(0, -1, map))return false;
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map){
        if(visited.contains(node)) return false;
        visited.add(node);
        for(int nb : map.get(node)){
            if(nb == parent) continue;
            boolean result = dfs(nb, node, map);
            if(!result) return false;
        }
        return true;
    }
}

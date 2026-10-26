class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        //tree is basically a graph without cycles, so if all nodes connected and no cycles we can say it's valid
        // create adjustment map, it's not directed so connections will be into two ways
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] e: edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        if(!dfs(0,-1,map)){
            return false;
        }
        return visited.size() == n;
    }

    private boolean dfs(int n, int parent, Map<Integer, List<Integer>> nodes){
        if(visited.contains(n)){
            return false;
        }
        visited.add(n);
        for(int nb : nodes.get(n)){
            if(nb == parent){
                continue;
            }
            if(!dfs(nb, n, nodes)){
                return false;
            }
        }
        return true;
    }
}

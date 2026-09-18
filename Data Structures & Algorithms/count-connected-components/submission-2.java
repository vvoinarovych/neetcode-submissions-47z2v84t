class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] v = new boolean[n];
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] e : edges){
            adj.computeIfAbsent(e[0], vl-> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], vl-> new ArrayList<>()).add(e[0]);
        }
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(!v[i]){
                dfs(edges, adj, v, i);
                counter++;
            }
        }
        return counter;
    }

    private void dfs(int[][] edges, Map<Integer, List<Integer>> adj, boolean[] v, int i){
        v[i] = true;
        for(int a : adj.get(i)){
            if(!v[a]){
                dfs(edges, adj, v, a);
            }
        }
    }
}

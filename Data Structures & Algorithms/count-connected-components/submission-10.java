class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int result = n;
        for(int[] e : edges){
            int start = e[0];
            int end = e[1];
            if(unite(start, end)){
                result--;
            }
        }
        return result;
    }

    private boolean unite(int start, int end){
        int f = find(start);
        int s = find(end);
        if(f == s){
            return false;
        }
        parent[f] = s;
        return true;
    }

    private int find(int node){
        int nd = parent[node];
        if(nd != parent[nd]){
            nd = find(parent[nd]);
        }
        return nd;
    }
}

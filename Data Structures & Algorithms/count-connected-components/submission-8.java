class Solution {
    Map<Integer, Integer> parent;
    public int countComponents(int n, int[][] edges) {
        parent = new HashMap<>();
        int counter = n;

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            if(union(u,v)){
                counter--;
            }
        }
        return counter;
    }

    boolean union(int f, int s){
        int first = find(f);
        int second = find(s);
        if(first == second){
            return false;
        }
        parent.put(first, second);
        return true;
    }

    int find(int node){
        parent.computeIfAbsent(node, v -> node);
        if(node != parent.get(node)){
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }
}

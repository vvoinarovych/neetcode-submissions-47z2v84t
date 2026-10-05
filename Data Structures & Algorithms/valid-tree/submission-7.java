class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        if(!dfs(0, -1, adj)) return false;
        return set.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map) {
        if (set.contains(node)) {
            return false;
        }
        set.add(node);

        for (int nb : map.get(node)) {
            if (nb == parent)
                continue;
            if (!dfs(nb, node, map))
                return false;
        }

        return true;
    }
}

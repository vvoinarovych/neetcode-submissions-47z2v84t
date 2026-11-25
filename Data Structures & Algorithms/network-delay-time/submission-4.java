class Solution {
    record Node(int v, int t){}
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> adj = new HashMap<>();
        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int tm = t[2];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(new Node(v, tm));
        }
        int[] best = new int[n + 1];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.t, b.t));
        pq.offer(new Node(k, 0));

        while(!pq.isEmpty()){
            Node nd = pq.poll();
            if(best[nd.v] < nd.t){
                continue;
            }
            for(Node node : adj.getOrDefault(nd.v, List.of())){
                int newTime = nd.t + node.t;
                if(best[node.v] > newTime){
                    best[node.v] = newTime;
                    pq.offer(new Node(node.v, newTime));
                }
            }
        }
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(best[i] == Integer.MAX_VALUE){
                return -1;
            }
            result = Math.max(best[i], result);
        }
        return result;
    }
}

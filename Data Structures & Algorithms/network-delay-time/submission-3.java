class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for(int[] t : times){
            int start = t[0];
            int target = t[1];
            int time = t[2];
            adj.computeIfAbsent(start, v -> new ArrayList<>()).add(List.of(target, time));
        }
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;        

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.get(1), b.get(1)));
        pq.offer(List.of(k, 0));

        while(!pq.isEmpty()){
            List<Integer> node = pq.poll();
            if(node.get(1) > distances[node.get(0)]){
                continue;
            }
            for(List<Integer> nb : adj.getOrDefault(node.get(0), List.of())){
                int newDistance = node.get(1) + nb.get(1);
                if(newDistance < distances[nb.get(0)]){
                    distances[nb.get(0)] = newDistance;
                    pq.offer(List.of(nb.get(0), newDistance));
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n ; i++){
            if(distances[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, distances[i]);
        }
        return max;        
    }
}

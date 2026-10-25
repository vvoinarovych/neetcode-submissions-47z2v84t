class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {        
        // build graph
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] t : times){
            map.computeIfAbsent(t[0], v -> new ArrayList<>()).add(new int[]{t[1], t[2]});            
        }

        //shortest dist
        int[] distances = new int[n + 1];        
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        //pair node and distanse to node from k
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int nd = node[0];
            int dist = node[1];
            if(dist > distances[nd]){
                continue;
            }
            distances[nd] = Math.min(dist, distances[nd]);
            for(int[] nb : map.getOrDefault(nd, List.of())){
                int curDist = dist + nb[1];
                if(curDist < distances[nb[0]]){
                    distances[nb[0]] = curDist;
                    pq.offer(new int[]{nb[0],curDist});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(distances[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, distances[i]);
        }
        return max;
    }
}

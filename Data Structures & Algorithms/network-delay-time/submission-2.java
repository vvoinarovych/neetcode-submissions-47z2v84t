class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k] = 0;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] t : times){
            int start = t[0];
            int end = t[1];
            int dist = t[2];
            map.computeIfAbsent(start, v -> new ArrayList<>()).add(new int[]{end, dist});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int node = poll[0];
            int dist = poll[1];
            if(dist > result[node]){
                continue;
            }
            for(int[] nb : map.getOrDefault(node, List.of())){
                int nbNode = nb[0];
                int nbDist = nb[1];
                int newDistance = dist + nbDist;
                if(newDistance < result[nbNode]){
                    pq.offer(new int[]{nbNode, newDistance});
                    result[nbNode] = newDistance;
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(result[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }
}

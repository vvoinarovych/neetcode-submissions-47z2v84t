class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // first we need to build our graf, we iterate over times and insert it into map of adjastments next way id0 - key in map
        // id1,id2 - go as int[] into List<int[]> we basically store all neighbours of node id0 in form of destination and distance

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] t : times){
            int start = t[0];
            int end = t[1];
            int dist = t[2];
            map.computeIfAbsent(start, v -> new ArrayList<>()).add(new int[]{end, dist});
        }
        //define list of all destances from k to node, by default it will be max int - means unreachable and 0 for k because we start here 
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k] = 0;

        //now we need priority queue in order to track node with smallest distance from node k, and insert our node k here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k, 0});

        //start traversing
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int val = node[0];
            int dist = node[1];

            //if we already found shorter way to this node we can skip checking it's neighbours cuz they are also for sure will have already calculated smaller distances
            if(dist > result[val]){
                continue;
            }
            for(int[] nb : map.getOrDefault(val, List.of())){
                //now calculate new distance for every neighbour, and if newly calculated distance is lower than already calculated in result
                //we update result and add this node to queue -> because it can lead to decreasing distances to this node neighbours
                int newDist = dist + nb[1];
                if(newDist < result[nb[0]]){
                    pq.offer(new int[]{nb[0], newDist});
                    result[nb[0]] = newDist;
                }
            }
        }
        //after we traversed all nodes we can search for the farthest one - it will be our result. Because if it's farthest means that all others are already reached. If we found unreached node (max int) we do early exit with -1, because we can't reach all nodes;
        int min = 0;
        for(int i = 1; i <= n; i++){
            if(result[i] == Integer.MAX_VALUE){
                return -1;
            }
            min = Math.max(min, result[i]);
        }
        return min;
    }
}

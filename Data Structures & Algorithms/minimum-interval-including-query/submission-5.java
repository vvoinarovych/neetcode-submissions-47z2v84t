class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<int[]> sortedQ = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            sortedQ.add(new int[]{queries[i], i});
        }
        Collections.sort(sortedQ, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int id = 0;
        int[] result = new int[queries.length];
        for(int[] q : sortedQ){

            while(id < intervals.length && intervals[id][0] <= q[0]){
                pq.offer(new int[]{intervals[id][1], intervals[id][1] - intervals[id][0] + 1});
                id++;
            }
            while(!pq.isEmpty() && q[0] > pq.peek()[0]){
                pq.poll();
            }
            result[q[1]] = pq.isEmpty() ? -1 : pq.peek()[1];
        }
        return result;
    }
}

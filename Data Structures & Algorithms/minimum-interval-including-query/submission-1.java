class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] sortedQ = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            sortedQ[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQ, (a, b) -> a[0]- b[0]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        int[] result = new int[queries.length];
        int id = 0;

        //[1,3],[2,3],[3,7],[6,6]
        //[1, 2, 3, 6, 7, 8]

        for(int[] q : sortedQ){
            while(id < intervals.length && intervals[id][0] <= q[0]){
                int len = intervals[id][1] - intervals[id][0] + 1;
                pq.offer(new int[]{intervals[id][1], len});
                id++;
            }

            while(!pq.isEmpty() && pq.peek()[0] < q[0]){
                pq.poll();
            }
            result[q[1]] = pq.isEmpty() ? -1 : pq.peek()[1];
        }
        return result;
    }
}

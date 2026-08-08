class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQ = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            sortedQ[i][0] = queries[i];
            sortedQ[i][1] = i;
        }
        Arrays.sort(sortedQ, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        //[1,3],[2,3],[3,7],[6,6]
        //[1, 2, 3, 6, 7, 8]
        int id = 0;
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] q =  sortedQ[i];
            while(id < intervals.length && q[0] >= intervals[id][0]){
                pq.offer(new int[]{intervals[id][1], intervals[id][1] - intervals[id][0] + 1});
                id++;
            }
            while(!pq.isEmpty() && q[0] > pq.peek()[0]){
                pq.poll();
            }
            result[q[1]] = pq.isEmpty() ? - 1 : pq.peek()[1];
        }
        return result;
    }
}

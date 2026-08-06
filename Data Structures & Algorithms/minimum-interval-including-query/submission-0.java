class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        //[1,3],[2,3],[3,7],[6,6]
        //[1, 2, 3, 6, 7, 8]
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i]; 
            sortedQueries[i][1] = i;          
        }

        Arrays.sort(sortedQueries, (a,b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[queries.length];
        int id = 0;

        for(int[] q : sortedQueries){
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

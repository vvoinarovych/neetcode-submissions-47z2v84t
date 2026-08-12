class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> count(a) - count(b));
        int[][] result = new int[k][2];
        for(int[] p : points){
            pq.offer(p);
        }
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;
    }

    private int count(int[] coords){
        return coords[0] * coords[0] + coords[1] * coords[1];
    }
}

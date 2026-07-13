class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(count(b), count(a)));
        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }      
        int[][] result = new int[k][2];  
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;
    }

    private int count (int[] c){
        return c[0] * c[0] + c[1] * c[1];
    }
}

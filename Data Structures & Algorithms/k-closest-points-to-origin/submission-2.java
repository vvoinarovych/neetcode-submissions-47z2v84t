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
    private int count(int[] arr){
        return arr[0] * arr[0] + arr[1] * arr[1];
    }
}

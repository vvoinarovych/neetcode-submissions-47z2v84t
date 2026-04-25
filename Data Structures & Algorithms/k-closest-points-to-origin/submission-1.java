class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(count(b), count(a)));
        for(int[] p : points){
            pq.offer(p);
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
        int a = arr[0];
        int b = arr[1];
        return a * a + b * b;
    }
}

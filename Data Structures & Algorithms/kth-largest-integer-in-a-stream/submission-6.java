class KthLargest {
    PriorityQueue<Integer> pq;
    int cap;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        cap = k;
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > cap){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > cap){
            pq.poll();
        }
        return pq.peek();
    } 
}

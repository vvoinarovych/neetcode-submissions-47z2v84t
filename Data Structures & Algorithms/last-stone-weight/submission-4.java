class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            pq.offer(s);
        }
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(Math.abs(a - b) > 0){
                pq.offer(Math.abs(a - b));
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}

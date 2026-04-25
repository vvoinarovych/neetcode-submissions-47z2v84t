class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int big = pq.poll();
            int secondBig = pq.poll();

            if(big > secondBig){
                pq.offer(big - secondBig);
            }
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}

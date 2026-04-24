class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();

            if(y > x){
                pq.offer(y - x);
            }
        }

        return pq.size() == 1 ? pq.peek() : 0;
    }
}

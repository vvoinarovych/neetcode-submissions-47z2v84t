class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(var entry : map.entrySet()){
            pq.offer(entry.getValue());
        }
        Deque<int[]> q = new ArrayDeque<>();

        int t = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            t++;
            if(pq.isEmpty()){
                int[] poll = q.peek();
                t = poll[1];                
            }else{
                int val = pq.poll();
                if(val > 1){
                    q.offer(new int[]{val - 1, t + n});
                }                
            }
            if(!q.isEmpty() && q.peek()[1] == t){
                pq.offer(q.poll()[0]);
            }
        }
        return t;
    }
}

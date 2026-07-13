class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : map.values()){
            pq.offer(val);
        }
        Queue<int[]> q = new LinkedList<>();
        int t = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            t++;
            if(!pq.isEmpty()){
                int poll = pq.poll();
                if(poll > 1) {
                    q.offer(new int[]{poll - 1, t + n});
                }
            }else{
                t = q.peek()[1];
            }
            if(!q.isEmpty() && q.peek()[1] == t){
                pq.offer(q.poll()[0]);
            }          
        }
        return t;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char t : tasks){
            count[t - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int c : count){
            if(c != 0){
                pq.offer(c);
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int pop = pq.poll();
                if(pop > 1){
                    q.offer(new int[]{pop - 1, time + n});
                }
            }else{
                time = q.peek()[1];
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}

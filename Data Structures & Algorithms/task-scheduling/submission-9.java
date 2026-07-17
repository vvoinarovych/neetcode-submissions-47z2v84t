class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int t : tasks){
            count[t - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int c : count){
            if(c > 0){
                pq.offer(c);
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int val = pq.poll() - 1;
                if(val > 0){
                    q.offer(new int[]{val, time + n});
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

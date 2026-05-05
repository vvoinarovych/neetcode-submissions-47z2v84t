class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt : count){
            if(cnt > 0){
               pq.offer(cnt);
            }
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            if(pq.isEmpty() && !q.isEmpty()){
                time = q.peek()[1];
            }else{
                time++;
            }
            
            if(!pq.isEmpty()){
                int val = pq.poll() - 1;
                if(val > 0){
                    q.offer(new int[]{val, time + n});
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}

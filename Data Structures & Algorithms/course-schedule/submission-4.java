class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] dep = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int prerequisite = pre[1];
            int course = pre[0];
            dep[course]++;
            adj.get(prerequisite).add(course);
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(dep[i] == 0){
                q.offer(i);
            }
        }
        int taken = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            taken++;
            for(int nb : adj.get(course)){
                dep[nb]--;
                if(dep[nb] == 0){
                    q.offer(nb);
                }
            }
        }
        return taken == numCourses;
    }
}

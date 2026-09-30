class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] dep = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] p : prerequisites){
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);
            dep[course]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(dep[i] == 0){
                q.offer(i);
            }            
        }

        int finish = 0;
        while(!q.isEmpty()){            
            int course = q.poll();            
            finish++;
            for(int c : adj.get(course)){
                dep[c]--;
                if(dep[c] == 0){
                    q.offer(c);
                }
            }
        }
        return finish == numCourses;
    }
}

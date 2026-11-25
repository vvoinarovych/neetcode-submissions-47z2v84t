class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] dep = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            dep[course]++;
            adj[prereq].add(course);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(dep[i] == 0){
                q.offer(i);
            }
        }
        int id = 0;
        int[] result = new int[numCourses];
        while(!q.isEmpty()){
            int course = q.poll();
            result[id] = course;
            id++;
            for(int nb : adj[course]){
                dep[nb]--;
                if(dep[nb] == 0){
                    q.offer(nb);
                }
            }
        }
        return id == numCourses ? result : new int[]{};
    }
}

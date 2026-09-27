class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] dep = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            dep[course]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < dep.length; i++){
            if(dep[i] == 0){
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int id = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            result[id] = course;
            id++;
            for(int nb : adj.get(course)){
                dep[nb]--;
                if(dep[nb] == 0){
                    q.offer(nb);
                }
            }
        }
        return id == numCourses ? result : new int[]{};
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> directions = new HashMap<>();
        int[] deps = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            directions.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];
            directions.get(prerequisite).add(course);
            deps[course]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(deps[i] == 0){
                q.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int id = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            order[id] = course;
            id++;
            for(int c : directions.get(course)){
                deps[c]--;
                if(deps[c] == 0){
                    q.offer(c);
                }
            }
        }
        return id < numCourses ? new int[]{} : order;
    }
}

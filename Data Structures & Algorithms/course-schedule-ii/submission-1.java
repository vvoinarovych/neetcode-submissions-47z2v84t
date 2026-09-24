class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] dep = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pr : prerequisites){
            int course = pr[0];
            int prerequisite = pr[1];
            dep[course]++;
            map.get(prerequisite).add(course);
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
            for(int pr : map.get(course)){
                dep[pr]--;
                if(dep[pr] == 0){
                    q.offer(pr);
                }
            }
        }
        if(result.length != id) return new int[]{};
        return result;
    }
}

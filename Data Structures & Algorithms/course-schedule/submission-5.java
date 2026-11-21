class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        int[] dep = new int[numCourses];

        for(int[] p : prerequisites){
            int course = p[0];
            int pre = p[1];
            map.get(pre).add(course);
            dep[course]++; 
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(dep[i] == 0){
                q.offer(i);
            }
        }
        int finished = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            finished++;
            for(int c : map.get(course)){
                dep[c]--;
                if(dep[c] == 0){
                    q.offer(c);
                    
                }
            }
        }
        return finished == numCourses;
    }
}

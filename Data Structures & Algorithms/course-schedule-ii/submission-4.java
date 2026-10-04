class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> dep = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
            dep.put(i, 0);
        }
        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
            dep.put(p[0], dep.getOrDefault(p[0], 0) + 1);
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(Map.Entry<Integer, Integer> e : dep.entrySet()){
            if(e.getValue() == 0){
                q.offer(e.getKey());
            }
        }
        
        int[] result = new int[numCourses];
        int id = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            result[id] = course;
            id++;

            for(int nb : adj.get(course)){
                dep.put(nb, dep.get(nb) - 1);
                if(dep.get(nb) == 0){
                    q.offer(nb);
                }
            }
        }
        return id == numCourses ? result : new int[]{};
    }
}

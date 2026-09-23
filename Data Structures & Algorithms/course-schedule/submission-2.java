class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] state = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] p : prerequisites){
            map.get(p[0]).add(p[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, map, state)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, int[] state){
        if(state[course] == 2) return true;
        if(state[course] == 1) return false;

        state[course] = 1;
        for(int pr : map.get(course)){
            if(!dfs(pr, map, state)){
                return false;
            }
        }
        state[course] = 2;
        return true;
    }
}

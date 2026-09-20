class Solution {
    int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] pr : prerequisites){
            map.get(pr[0]).add(pr[1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, map)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map){
        if(state[course] == 1){
            return false;
        }
        if(state[course] == 2){
            return true;
        }
        state[course] = 1;
        for(int pr : map.get(course)){
            boolean result = dfs(pr, map);
            if(!result) return false;
        }
        state[course] = 2;
        return true;
    }
}

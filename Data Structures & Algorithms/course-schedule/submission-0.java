class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dep = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            dep.put(i, new ArrayList<>());
        }
        for(int[] pr : prerequisites){
            dep.get(pr[0]).add(pr[1]);
        }
        
        for(int i = 0; i < numCourses; i++){
            boolean result = dfs(dep, i);
            if(!result) return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> dep, int course){
        if(visited.contains(course)) return false;
        if(dep.get(course).isEmpty()) return true;
        visited.add(course);
        for(int req : dep.get(course)){
            if(!dfs(dep, req)) return false;
        }
        visited.remove(course);
        dep.put(course, new ArrayList<>());
        return true;
    }
}

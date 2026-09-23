class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pr : prerequisites){
            in[pr[0]]++;
            adj.get(pr[1]).add(pr[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);

            for(int nb : adj.get(node)){
                in[nb]--;
                if(in[nb] == 0){
                    q.offer(nb);
                }
            }
        }
        return result.size() == numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}

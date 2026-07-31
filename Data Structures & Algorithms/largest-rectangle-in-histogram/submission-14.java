class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int id = i;
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                int[] pop = stack.pop();
                int v = pop[0];
                id = pop[1];
                max = Math.max(max, (i - id) * v);
            }
            stack.push(new int[]{heights[i], id});
        }

        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            max = Math.max(max, (heights.length - pop[1]) * pop[0]);
        }
        return max;
    }
}

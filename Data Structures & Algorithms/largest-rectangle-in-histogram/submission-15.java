class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int id = i;
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                int[] pop = stack.pop();
                id = pop[1];
                max = Math.max(max, pop[0]*(i - id));
            }
            stack.push(new int[]{heights[i], id});
        }

        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            max = Math.max(max, pop[0] * (heights.length - pop[1]));
        }
        return max;
    }
}

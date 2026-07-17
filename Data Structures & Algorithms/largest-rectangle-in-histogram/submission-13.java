class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int id = i;
            while(!stack.isEmpty() && heights[i] < stack.peek()[0]){
                int[] pop = stack.pop();
                id = pop[1];
                int h = pop[0];
                max = Math.max(max, h * (i - id));
            }
            stack.push(new int[]{heights[i], id});
        }
        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            int h = pop[0];
            int id = pop[1];
            max = Math.max(max, h * (heights.length - id));
        }
        return max;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && heights[i] < stack.peek()[0]){
                int[] pop = stack.pop();
                int area = (i - pop[1]) * pop[0];
                max = Math.max(max, area);
                start = pop[1];
            }
            stack.push(new int[]{heights[i], start});
        }
        while(!stack.isEmpty()){
            var pop = stack.pop();
            max = Math.max(max, (heights.length - pop[1]) * pop[0]); 
        }
        return max;
    }
}

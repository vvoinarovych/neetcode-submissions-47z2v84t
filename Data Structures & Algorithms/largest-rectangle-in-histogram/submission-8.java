class Solution {
    public int largestRectangleArea(int[] heights) {
       Deque<int[]> stack = new ArrayDeque<>(); 
       int maxArea = 0;
       for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && heights[i] < stack.peek()[0]){
                var pop = stack.pop();
                int area = (i - pop[1]) * pop[0];
                start = pop[1];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(new int[]{heights[i], start});
       }
       while(!stack.isEmpty()){
        var pop = stack.pop();
        maxArea = Math.max(maxArea, (heights.length - pop[1]) * pop[0]);
       }
       return maxArea;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int h = heights[i];
            int start = i;

            while(!stack.isEmpty() && stack.peek()[0] > h){
                int[] pop = stack.pop();   
                start = pop[1];             
                int area = pop[0] * (i - start);
                maxArea = Math.max(area, maxArea);
                
            }
            stack.push(new int[]{h, start});
        }
        for(int[] lo : stack){
            maxArea = Math.max((heights.length - lo[1]) * lo[0], maxArea);
        }
        return maxArea;
    }
}


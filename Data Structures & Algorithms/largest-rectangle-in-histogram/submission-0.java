class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, (i - index) * height);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }
        for(int[] left : stack){
            maxArea = Math.max(maxArea, (heights.length - left[0]) * left[1]);
        }
        return maxArea;
    }
}

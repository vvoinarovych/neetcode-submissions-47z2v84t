class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int id = i;
            while(!stack.isEmpty() && stack.peek()[0] >= heights[i]){
                var pop = stack.pop();
                int h = pop[0];
                int index = pop[1];
                id = index;
                int curr = (i - index) * h;
                max = Math.max(curr, max);     
            }
            stack.push(new int[]{heights[i], id});
        }
        while(!stack.isEmpty()){
            var pop = stack.pop();
            max = Math.max(max, (heights.length - pop[1]) * pop[0]);
        }
        return max;
    }
   
}


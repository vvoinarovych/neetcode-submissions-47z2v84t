class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int[] pop = stack.pop();
                result[pop[1]] = i - pop[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}

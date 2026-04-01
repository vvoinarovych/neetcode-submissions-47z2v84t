class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                int[] pop = stack.pop();
                int days = i - pop[1];
                result[pop[1]] = days;
            }
            stack.push(new int[]{t, i});
        }
        return result;
    }
}

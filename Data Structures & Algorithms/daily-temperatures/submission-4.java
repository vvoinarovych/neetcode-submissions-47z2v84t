class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length]; 
        for(int i = 0; i < temperatures.length; i++){

            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int[] pop = stack.pop();
                int index = pop[1];
                result[index] = i - index; 
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}

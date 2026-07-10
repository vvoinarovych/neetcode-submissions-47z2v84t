class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            while(!dq.isEmpty() && temp > temperatures[dq.peek()]){
                int pop = dq.pop();
                result[pop] = i - pop;
            }
            dq.push(i);
        }
        return result;
    }
}

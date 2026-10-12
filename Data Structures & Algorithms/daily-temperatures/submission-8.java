class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> set = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!set.isEmpty() && temperatures[set.peek()] < temperatures[i]){
                int pop = set.pop();
                result[pop] = i - pop;
            }
            set.add(i);
        }
        return result;
    }
}

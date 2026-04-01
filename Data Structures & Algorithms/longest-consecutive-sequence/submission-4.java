class Solution {
    public int longestConsecutive(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int n: nums){
          stack.add(n);
        }
        int longest = 0;

        for(int n : stack){
          if(stack.contains(n-1)){
            continue;
          }
          int streak = 0;
          while(stack.contains(n + streak)){
            streak++;
          }
          longest = Math.max(longest, streak);
        }
        return longest;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
          set.add(n);
        }
        int maxLength = 0;
        for(int n : set){
          int len = 0;
          if(!set.contains(n - 1)){
            while(set.contains(n + len)){
              len++;
            }
          maxLength = Math.max(maxLength, len);
          }
        }
        return maxLength;
    }
}

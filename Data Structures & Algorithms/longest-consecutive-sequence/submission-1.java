class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for(int n: nums){
        set.add(n);
      }
      int counter = 0;

      for(int n : nums){
        
        if(!set.contains(n - 1)){
            int seq = n + 1;
            int lc = 1;
            while(set.contains(seq)){
                lc++;
                seq++;                
            }
            counter = Math.max(counter, lc);
        }
      }
      return counter;
    }
}

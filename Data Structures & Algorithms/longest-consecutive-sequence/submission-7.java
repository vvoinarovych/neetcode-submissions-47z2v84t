class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
          set.add(num);
        }
        int max = 0;
        for(int num : nums){
          if(set.contains(num - 1)){
            continue;
          }
          int toAdd = 1;
          while(set.contains(num + toAdd)){
            toAdd++;
          }
          max = Math.max(max, toAdd);
        }
        return max;
    }
}

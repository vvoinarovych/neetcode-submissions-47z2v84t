class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int num : nums){
          set.add(num);
        }

        for(int num : set){
          if(set.contains(num - 1)){
            continue;
          }
          int len = 1;
          while(set.contains(num + len)){
            len++;
          }
          result = Math.max(result, len);
        }
        return result;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int num : nums){
          set.add(num);
        }

        for(int num : set){
          int add = 0;
          if(set.contains(num - 1)){
            continue;
          }
          while(set.contains(num + add)){
            add++;
          }
          longest = Math.max(longest, add);
        }
        return longest;
    }
}

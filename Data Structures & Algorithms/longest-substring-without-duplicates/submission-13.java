class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            char rchar = s.charAt(r);
            while(set.contains(rchar)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(rchar);
            max = Math.max(max, set.size());
        }
        return max;
    }
}

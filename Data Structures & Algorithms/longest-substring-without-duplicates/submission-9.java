class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> count = new HashSet<>();
        int max = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){

            while(count.contains(s.charAt(r))){
                count.remove(s.charAt(l));
                l++;
            }
            count.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}

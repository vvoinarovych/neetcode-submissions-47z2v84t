class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int longest = 0;
        int l = 0;
        int mostF = 0;
        for(int r = 0; r < s.length(); r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            mostF = Math.max(mostF, count.get(s.charAt(r)));
            while(r - l + 1 - mostF > k){
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}

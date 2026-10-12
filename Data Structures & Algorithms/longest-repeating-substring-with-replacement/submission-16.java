class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int result = 0;
        int l = 0;
        int mostF = 0;
        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            count.put(rc, count.getOrDefault(rc, 0) + 1);
            mostF = Math.max(mostF, count.get(rc));

            while(r - l + 1 - mostF > k){
                char lc = s.charAt(l);
                count.put(lc, count.get(lc) - 1);
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        int mostF = 1;
        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            mostF = Math.max(mostF, map.get(rc));
            while(r - l + 1 - mostF > k){
                char lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                l++;
            }
            max = Math.max(r - l + 1, max);
        }
        return max;
    }
}

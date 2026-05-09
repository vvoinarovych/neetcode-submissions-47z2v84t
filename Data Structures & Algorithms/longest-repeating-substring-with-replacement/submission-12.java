class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; 
        int max = 0;  
        int result = 0;     
        Map<Character, Integer> count = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            count.put(rc, count.getOrDefault(rc, 0) + 1);
            max = Math.max(count.get(rc), max);

            if(r - l - max + 1 > k){
                char lc = s.charAt(l);
                count.put(lc, count.get(lc) - 1);
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}

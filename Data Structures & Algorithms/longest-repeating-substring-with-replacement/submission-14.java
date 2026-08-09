class Solution {
    public int characterReplacement(String s, int k) {        
        Map<Character, Integer> w = new HashMap<>();
        int l = 0;
        int max = 0;
        int mostF = 0;
        for(int r = 0; r < s.length(); r++){
            char rchar = s.charAt(r);
            w.put(rchar, w.getOrDefault(rchar, 0) + 1);
            mostF = Math.max(mostF, w.get(rchar));
            while(r - l - mostF + 1 > k){                
                w.put(s.charAt(l), w.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(r - l + 1, max);            
        }
        return max;
    }
}

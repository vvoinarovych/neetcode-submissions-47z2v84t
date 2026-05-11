class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> ct = new HashMap<>();
        for(char ch : t.toCharArray()){
            ct.put(ch, ct.getOrDefault(ch, 0) + 1);
        }
        int need = ct.size();
        int have = 0;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        Map<Character, Integer> cs = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            cs.put(rc, cs.getOrDefault(rc, 0) + 1);
            if(ct.containsKey(rc) && ct.get(rc).equals(cs.get(rc))){
                have++;
            }
            while(need == have){
                char lc = s.charAt(l);
                if(r - l + 1 < min){
                    min = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }
                cs.put(lc, cs.get(lc) - 1);
                if(ct.containsKey(lc) && cs.get(lc) < ct.get(lc)){
                    have--;
                }
                l++;                
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}

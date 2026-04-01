class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tc = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char ch : t.toCharArray()){
            tc.put(ch, tc.getOrDefault(ch, 0) + 1);
        }
        int need = tc.size();
        int have = 0;
        int minL = Integer.MAX_VALUE;
        int res[] = new int[2];

        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            window.put(rc, window.getOrDefault(rc, 0) + 1);

            if(tc.containsKey(rc) && tc.get(rc).equals(window.get(rc))){
                have++;
            }

            while(need == have){
                if(r - l + 1 < minL){
                    minL = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char lc = s.charAt(l);
                window.put(lc, window.get(lc) - 1);

                if(tc.containsKey(lc) && window.get(lc) < tc.get(lc)){
                    have--;
                }
                l++;
            }
        }

        return minL == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tcount = new HashMap<>();
        for(char ch : t.toCharArray()){
            tcount.put(ch, tcount.getOrDefault(ch, 0) + 1);
        }
        int need = tcount.size();
        int have = 0;
        int[] range = new int[2];
        int shortest = Integer.MAX_VALUE;
        Map<Character, Integer> scount = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char rchar = s.charAt(r);
            scount.put(rchar, scount.getOrDefault(rchar, 0) + 1);
            if(tcount.containsKey(rchar) && tcount.get(rchar) == scount.get(rchar)){
                have++;
            }
            while(need == have){
                char lchar = s.charAt(l);
                if(shortest > r-l+1){
                    shortest = r -l + 1;
                    range[0] = l;
                    range[1] = r;                    
                }
                scount.put(lchar, scount.get(lchar) - 1);
                if(tcount.containsKey(lchar) && scount.get(lchar) < tcount.get(lchar)){
                    have--;
                }
                l++;
            }
        }
        return shortest == Integer.MAX_VALUE ? "" : s.substring(range[0], range[1] + 1);
    }
}

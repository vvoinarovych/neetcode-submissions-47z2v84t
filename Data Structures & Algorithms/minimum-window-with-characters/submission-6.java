class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tcount = new HashMap<>();
        for(char ch : t.toCharArray()){
            tcount.put(ch, tcount.getOrDefault(ch, 0) + 1);
        }        
        Map<Character, Integer> window = new HashMap<>();
        int need = tcount.size();
        int have = 0;
        int maxSize = Integer.MAX_VALUE;
        int[] result = new int[2];

        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char rchar = s.charAt(r);
            window.put(rchar, window.getOrDefault(rchar, 0) + 1);
            if(tcount.containsKey(rchar) && tcount.get(rchar).equals(window.get(rchar))){
                have++;;
            }

            while(need == have){
                if(r - l + 1 < maxSize){
                    maxSize = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }

                char lchar = s.charAt(l);
                window.put(lchar, window.get(lchar) - 1);
                if(tcount.containsKey(lchar) && window.get(lchar) < tcount.get(lchar)){
                    have--;
                }
                l++;
            }
        }
        return maxSize == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}

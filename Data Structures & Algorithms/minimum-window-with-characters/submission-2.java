class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for(char ch : t.toCharArray()){
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> sCount = new HashMap<>();
        int need = tCount.size();
        int have = 0;
        int l = 0;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        for(int r = 0; r < s.length(); r++){
            char rChar = s.charAt(r);
            sCount.put(rChar, sCount.getOrDefault(rChar, 0) + 1);

            if(tCount.containsKey(rChar) && sCount.get(rChar).equals(tCount.get(rChar))){
                have++;
            }

            while(have == need){
                if(r - l < min){
                    min = r - l;
                    result[0] = l;
                    result[1] = r;
                }
                char lChar = s.charAt(l); 
                sCount.put(lChar, sCount.get(lChar) - 1);

                if(tCount.containsKey(lChar) && sCount.get(lChar) < tCount.get(lChar)){
                    have--;
                }
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}

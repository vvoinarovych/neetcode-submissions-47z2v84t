class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for(char ch : t.toCharArray()){
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }
        int need = tCount.size();
        int have = 0;
        int[] result = new int[2];
        int l = 0;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> sCount = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            char rChar = s.charAt(r);
            sCount.put(rChar, sCount.getOrDefault(rChar, 0) + 1);
            if(tCount.containsKey(rChar) && tCount.get(rChar).equals(sCount.get(rChar))){
                have++;
            }

            while(have == need){
                if(r - l + 1 < min){
                    min = r - l + 1;
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

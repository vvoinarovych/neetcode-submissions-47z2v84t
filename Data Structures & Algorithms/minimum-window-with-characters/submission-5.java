class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();
        for(char ch : t.toCharArray()){
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }
        int need = freqT.size();
        int have = 0;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        Map<Character, Integer> freqS = new HashMap<>();
        int l = 0;

        for(int  r = 0; r < s.length(); r++){
            char charR = s.charAt(r);
            freqS.put(charR, freqS.getOrDefault(charR, 0) + 1);
            if(freqT.containsKey(charR) && freqS.get(charR).equals(freqT.get(charR))){
                have++;
            }

            while(need == have){
                if(r - l  < min){
                    min = r - l;
                    result[0] = l;
                    result[1] = r;
                }
                char charL = s.charAt(l);
                freqS.put(charL, freqS.get(charL) - 1);
                if(freqT.containsKey(charL) && freqS.get(charL) < freqT.get(charL)){
                    have--;
                }
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}

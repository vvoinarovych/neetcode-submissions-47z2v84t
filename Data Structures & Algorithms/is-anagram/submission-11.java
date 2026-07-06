class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sC = new int[26];
        int[] tC = new int[26];
        for(int i = 0; i < s.length(); i++){
            sC[s.charAt(i) - 'a']++;
            tC[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(sC, tC);        
    }
}

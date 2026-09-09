class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sc = new int[26];
        int[] tc = new int[26];
        for(int i = 0; i < s.length(); i++){
            sc[s.charAt(i) -'a']++;
            tc[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(sc, tc);
    }
}

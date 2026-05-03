class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for(char ch : s.toCharArray()){
            sCount[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            tCount[ch - 'a']++;
        }
        return Arrays.equals(sCount, tCount);
    }
}

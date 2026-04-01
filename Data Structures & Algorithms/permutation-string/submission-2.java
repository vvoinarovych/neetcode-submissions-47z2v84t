class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1c = new char[26]; 
        for(char ch : s1.toCharArray()){
            s1c[ch - 'a']++;
        }
        int l = 0;
        char[] s2c = new char[26];
        for(int r = 0; r < s2.length(); r++){
            s2c[s2.charAt(r) - 'a']++;
            while(r - l + 1 > s1.length()){
                s2c[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(s1c, s2c)){
                return true;
            }
        }
        return false;
    }
}
